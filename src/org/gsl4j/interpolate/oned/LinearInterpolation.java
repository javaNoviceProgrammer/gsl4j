package org.gsl4j.interpolate.oned;

import org.gsl4j.util.NativeLibraryLoader;

public class LinearInterpolation {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	double[] x ;
	double[] y ;

	public LinearInterpolation(double[] x, double[] y) {
		this.x = x ;
		this.y = y ;
		cacheData() ;
	}

	private native void cacheData() ;

	public native String name() ;
	public native int minSize() ;

	public native double eval(double x) ;
	public native double deriv(double x) ;
	public native double deriv2(double x) ;
	public native double integrate(double a, double b) ;




}
