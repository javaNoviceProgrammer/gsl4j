package org.gsl4j;

import org.gsl4j.util.NativeLibraryLoader;

public class ElementaryFunctions {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private ElementaryFunctions() {

	}

	public static native double log1p(double x) ;
	public static native double expm1(double x) ;
	public static native double hypot(double x, double y) ;
	public static native double hypot3(double x, double y, double z) ;

	public static native double acosh(double x) ;
	public static native double asinh(double x) ;
	public static native double atanh(double x) ;

	public static native double ldexp(double x, int n) ;
	public static native double[] frexp(double x, int n) ;

	public static native double powInt(double x, int n) ;
	public static native double pow2(double x) ;
	public static native double pow3(double x) ;
	public static native double pow4(double x) ;
	public static native double pow5(double x) ;
	public static native double pow6(double x) ;
	public static native double pow7(double x) ;
	public static native double pow8(double x) ;
	public static native double pow9(double x) ;

	public static native int sign(double x) ;
	public static native boolean isOdd(int x) ;
	public static native boolean isEven(int x) ;

	public static native double max(double a, double b) ;
	public static native double min(double a, double b) ;

	public static native int fcmp(double x, double y, double epsilon) ;

	public static native double multiply(double x, double y) ;
	public static native double multiplyError(double x, double dx, double y, double dy) ;

}
