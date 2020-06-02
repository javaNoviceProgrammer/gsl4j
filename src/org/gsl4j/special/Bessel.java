package org.gsl4j.special;

import org.gsl4j.util.NativeLibraryLoader;

public class Bessel {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private Bessel() {

	}

	public static native double J0(double x) ;
	public static native double J1(double x) ;
	public static native double Jn(int n, double x) ;
	public static native double[] JnArray(int nmin, int nmax, double x) ;

	public static native double Y0(double x) ;
	public static native double Y1(double x) ;
	public static native double Yn(int n, double x) ;
	public static native double[] YnArray(int nmin, int nmax, double x) ;

	public static native double I0(double x) ;
	public static native double I1(double x) ;
	public static native double In(int n, double x) ;
	public static native double[] InArray(int nmin, int nmax, double x) ;

	public static native double I0Scaled(double x) ;
	public static native double I1Scaled(double x) ;
	public static native double InScaled(int n, double x) ;
	public static native double[] InScaledArray(int nmin, int nmax, double x) ;

	public static native double K0(double x) ;
	public static native double K1(double x) ;
	public static native double Kn(int n, double x) ;
	public static native double[] KnArray(int nmin, int nmax, double x) ;

	public static native double K0Scaled(double x) ;
	public static native double K1Scaled(double x) ;
	public static native double KnScaled(int n, double x) ;
	public static native double[] KnScaledArray(int nmin, int nmax, double x) ;


}
