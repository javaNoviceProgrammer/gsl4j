package org.gsl4j.complex;

import org.gsl4j.util.NativeLibraryLoader;

public class TestNative {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	public native double airy(double x) ;

	public static void main(String[] args) {
		TestNative test = new TestNative() ;
		double result = test.airy(1.2) ;
		System.out.println(result);

	}

}
