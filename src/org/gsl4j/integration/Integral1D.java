package org.gsl4j.integration;

import org.gsl4j.util.NativeLibraryLoader;

public class Integral1D {

	static {
		NativeLibraryLoader.loadLibraries();
		initFieldIDs();
	}

	private static native void initFieldIDs() ;

	// setting up the constructors

	IntegralFunction1D func ;
	double absErr = 1e-10 ;
	double relErr = 1e-10 ;
	int maxNumberOfIntervals = 100 ;

	public Integral1D() {

	}

	public Integral1D(IntegralFunction1D func) {
		this.func = func ;
	}

	public void setIntegralFunction(IntegralFunction1D func) {
		this.func = func ;
	}

	// QNG non-adaptive Gauss-Kronrod integration over (a,b) interval
	public native double[] qngDetailed(double a, double b) ;
	public native double qng(double a, double b) ;

	// QAG adaptive integration over (a,b) interval
	public native double qagGauss15(double a, double b) ;
	public native double qagGauss21(double a, double b) ;
	public native double qagGauss31(double a, double b) ;
	public native double qagGauss41(double a, double b) ;
	public native double qagGauss51(double a, double b) ;
	public native double qagGauss61(double a, double b) ;

	// QAGS adaptive integration with singularities over (a,b) interval




}
