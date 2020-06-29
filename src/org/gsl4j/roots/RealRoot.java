package org.gsl4j.roots;

import org.gsl4j.function.MathFunction;
import org.gsl4j.util.NativeLibraryLoader;

public class RealRoot {

	static {
		NativeLibraryLoader.loadLibraries();
		initFieldIDs() ;
	}

	private static native void initFieldIDs() ;

	double absErr = 1e-10 ;
	double relErr = 1e-10 ;
	int maxNumberOfIterations = 100 ;
	RealRootFunction func ;

	public RealRoot() {

	}

	public RealRoot(RealRootFunction func) {
		this.func = func ;
	}

	public RealRoot(MathFunction func) {
		this.func = t -> func.value(t) ;
	}

	public void setFunction(RealRootFunction func) {
		this.func = func ;
	}

	// Root Bracketing Algorithms
	public native double bisection(double start, double end) ;
	public native double falsepos(double start, double end) ;
	public native double brent(double start, double end) ;

	// Root Finding Algorithms using Derivatives
	public native double newton(double estimate) ;
	public native double secant(double estimate) ;
	public native double steffenson(double estimate) ;


}
