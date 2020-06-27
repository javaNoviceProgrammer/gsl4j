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
	public native double qng(double a, double b) ;
	public native double[] qngDetailed(double a, double b) ;

	// QAG adaptive integration over (a,b) interval
	public native double qagGauss15(double a, double b) ;
	public native double[] qagGauss15withError(double a, double b) ;
	public native double qagGauss21(double a, double b) ;
	public native double[] qagGauss21withError(double a, double b) ;
	public native double qagGauss31(double a, double b) ;
	public native double[] qagGauss31withError(double a, double b) ;
	public native double qagGauss41(double a, double b) ;
	public native double[] qagGauss41withError(double a, double b) ;
	public native double qagGauss51(double a, double b) ;
	public native double[] qagGauss51withError(double a, double b) ;
	public native double qagGauss61(double a, double b) ;
	public native double[] qagGauss61withError(double a, double b) ;

	// QAGS adaptive integration with singularities over (a,b) interval
	public native double qags(double a, double b) ;
	public native double[] qagsWithError(double a, double b) ;

	// QAGP adaptive integration with known singular points
	public native double qagp(double a, double b, double[] breakPoints) ;
	public native double[] qagpWithError(double a, double b, double[] breakPoints) ;

	// QAGI adaptive integration on infinite intervals
	public native double qagi() ;
	public native double[] qagiWithError() ;
	public native double qagiu(double a) ;
	public native double qagil(double b) ;

	// QAWC adaptive integration for Cauchy principal values
	public native double qawc(double a, double b, double c) ;

	// QAWS adaptive integration for singular functions
	public native double qaws(double a, double b) ;

	// QAWO adaptive integration for oscillatory functions
	public static final int GSL_INTEG_COSINE = 0 ;
	public static final int GSL_INTEG_SINE = 1 ;
	public native double qawo(int choice, double omega, double a, double b) ;

	// QAWF adaptive integration for Fourier integrals
	public native double qawf(int choice, double omega, double a, double b) ;

	// CQUAD doubly-adaptive integration
	public native double cquad(double a, double b) ;

	// Romberg integration
	public native double romberg(double a, double b) ;

	// Gauss-Legendre integration
	public native double glfixed(double a, double b) ;

	// Fixed point quadratures
	public static final int FIXED_LEGENDRE = 2 ;
	public static final int FIXED_CHEBYSHEV = 3 ;
	public static final int FIXED_GEGENBAUER = 4 ;
	public static final int FIXED_JACOBI = 5 ;
	public static final int FIXED_LAGUERRE = 6 ;
	public static final int FIXED_HERMITE = 7 ;
	public static final int FIXED_EXPONENTIAL = 8 ;
	public static final int FIXED_RATIONAL = 9 ;
	public static final int FIXED_CHEBYSHEV2 = 10 ;

	public native double fixed(double a, double b) ;

}
