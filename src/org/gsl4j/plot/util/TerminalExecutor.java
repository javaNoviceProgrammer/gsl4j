package org.gsl4j.plot.util;

import java.io.IOException;
import java.util.Scanner;


public class TerminalExecutor {

	private TerminalExecutor() {

	}

	private static void executeCommand(boolean silent, String toolname, String filename, String... args) {
		// build the command
		StringBuilder sb = new StringBuilder() ;
		sb.append(toolname).append(" ") ;
		if(args != null && args.length > 0) {
			for(int i=0; i<args.length; i++)
				sb.append(args[i] + " ") ;
		}
		sb.append(filename) ;
		// execute on the terminal (command line)
		Runtime rt = Runtime.getRuntime() ;
		try {
			Process process = rt.exec(sb.toString()) ;
			// output stream
			Thread thread1 = new Thread(() -> {
				Scanner result = new Scanner(process.getInputStream()) ;
					while(result.hasNext()) {
						if(!silent) {
							System.out.println(result.nextLine());
						}
						else {
							result.hasNextLine() ;
						}
				}
				result.close();
			}) ;
			thread1.start();
			// error stream
			Thread thread2 = new Thread(() -> {
				String line = "" ;
				Scanner error = new Scanner(process.getErrorStream()) ;
					while(error.hasNext()) {
						line = error.nextLine() ;
						if(!silent) {
							if(line.contains("error"))
								System.err.println(line);
							else
								System.out.println(line);
						}
				}
				error.close();
			}) ;
			thread2.start();
			// wait for execution
			if(!silent) {
				System.out.println("---> Executing terminal command");
			}
			thread1.join(500L);
			thread2.join(500L);
			if(!silent) {
				System.out.println("---> Finished execution of terminal command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void execute(String toolname, String filename, String... args) {
		executeCommand(false, toolname, filename, args);
	}

	public static void executeSilently(String toolname, String filename, String... args) {
		executeCommand(true, toolname, filename, args);
	}

}
