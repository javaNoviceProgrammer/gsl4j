package org.gsl4j.util;

class OSUtils {

	private static String OS = System.getProperty("os.name") ;

	public static boolean isMac() {
		return OS.toLowerCase().contains("mac") ;
	}

	public static boolean isWindows() {
		return OS.toLowerCase().contains("win") ;
	}

	public static boolean isLinux() {
		return OS.toLowerCase().contains("nux") ;
	}

	public static void main(String[] args) {
		System.out.println(OS);
		System.out.println(isMac());
		System.out.println(isWindows()); ;
		System.out.println(isLinux()); ;
	}

}
