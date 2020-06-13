package org.gsl4j.special;

import org.gsl4j.util.NativeLibraryLoader;

public class Digamma {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private Digamma() {

	}

	// Digamma Function
	public static native double psiInt(int n) ;
	public static native double digamma(int n) ;
	public static native double psi(double x) ;
	public static native double digamma(double x) ;
	public static native double psi1piy(double y) ;

	// Trigamma Function
	public static native double psi1int(int n) ;
	public static native double psi1(double x) ;
	public static native double trigamma(double x) ;

	// Polygamma Function
	public static native double psiN(int n, double x) ;
	public static native double polygamma(int n, double x) ;

}
