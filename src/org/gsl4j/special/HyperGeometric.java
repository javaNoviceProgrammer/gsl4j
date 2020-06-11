package org.gsl4j.special;

import org.gsl4j.util.NativeLibraryLoader;

public class HyperGeometric {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private HyperGeometric() {

	}

	// Hypergeometric Functions
	public static native double hyperg0F1(double c, double x) ;
	public static native double hyperg1F1int(int m, int n, double x) ;
	public static native double hyperg1F1(double a, double b, double x) ;
	public static native double hypergUint(int m, int n, double x) ;
	public static native double[] hypergUintE10(int m, int n, double x) ;
	public static native double hypergU(double a, double b, double x) ;
	public static native double[] hypergUe10(double a, double b, double x) ;
	public static native double hyperg2F1(double a, double b, double c, double x) ;
	public static native double hyperg2F1conj(double aR, double aI, double c, double x) ;
	public static native double hyperg2F1renorm(double a, double b, double c, double x) ;
	public static native double hyperg2F1conjRenorm(double aR, double aI, double c, double x) ;
	public static native double hyperg2F0(double a, double b, double x) ;

}
