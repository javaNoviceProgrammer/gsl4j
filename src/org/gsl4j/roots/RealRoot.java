package org.gsl4j.roots;

import org.gsl4j.util.NativeLibraryLoader;

public class RealRoot {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	double absError ;
	double relError ;
	RealRootFunction func ;

	public RealRoot() {} ;

	public RealRoot(RealRootFunction func) {
		this.func = func ;
	}

	public void setFunction(RealRootFunction func) {
		this.func = func ;
	}

	public static native double func(RealRootFunction func, double x) ;


	// Root Bracketing Algorithms
	public native double bisection(double start, double end) ;
	public native double falsepos(double start, double end) ;
	public native double brent(double start, double end) ;

	// Root Finding Algorithms using Derivatives
	public native double newton(double estimate) ;
	public native double secant(double estimate) ;
	public native double steffenson(double estimate) ;


}
