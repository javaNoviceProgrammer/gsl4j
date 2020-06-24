package org.gsl4j.interpolate;

import org.gsl4j.util.NativeLibraryLoader;

public class Interpolation1D {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	public static final int LINEAR = 0 ;
	public static final int POLYNOMIAL = 1 ;
	public static final int CUBIC_SPLINE = 2 ;
	public static final int CUBIC_SPLINE_PERIODIC = 3 ;
	public static final int AKIMA = 4 ;
	public static final int AKIMA_PERIODIC = 5 ;
	public static final int STEFFEN = 6 ;

	double[] x ;
	double[] y ;
	int type ;

	public Interpolation1D(double[] x, double[] y, int type) {
		this.x = x ;
		this.y = y ;
		this.type = type ;
		cacheData(type) ;
	}

	private native void cacheData(int type) ;

	public native String name() ;
	public native int minSize() ;

	public native double eval(double x) ;
	public native double deriv(double x) ;
	public native double deriv2(double x) ;
	public native double integrate(double a, double b) ;

}
