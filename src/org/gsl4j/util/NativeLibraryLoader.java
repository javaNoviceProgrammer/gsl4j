package org.gsl4j.util;

import java.io.IOException;

public class NativeLibraryLoader {

	private static boolean isLoaded = false ;

	private NativeLibraryLoader() {

	}

	public static void loadLibraries() {
		if(isLoaded) {
			return ;
		}
		else {
			if(OSUtils.isMac())
				loadMacLibraries();
			else if(OSUtils.isLinux())
				loadLinuxLibraries();
			else if(OSUtils.isWindows())
				loadWindowsLibraries();
			else
				System.out.println("Operating System NOT supported.");

			isLoaded = true ;
		}
	}

	private static void loadMacLibraries() {
		// load core gsl library
		try {
			NativeUtils.loadLibraryFromJar("/libgsl.25.dylib");
		} catch (IOException e) {
			System.err.println("Could not load GSL dynamic library");
		}
		// load gsl cblas library
		try {
			NativeUtils.loadLibraryFromJar("/libgslcblas.0.dylib");
		} catch (IOException e) {
			System.err.println("Could not load GSL CBLAS dynamic library");
		}
		// load gsl4j library
		try {
			NativeUtils.loadLibraryFromJar("/libgsl4jc.dylib");
		} catch (IOException e) {
			System.err.println("Could not load GSL4j dynamic library");
		}
	}

	// linux
	private static void loadLinuxLibraries() {

	}

	// windows
	private static void loadWindowsLibraries() {

	}

}
