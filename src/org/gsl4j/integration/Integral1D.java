package org.gsl4j.integration;

import org.gsl4j.util.NativeLibraryLoader;

public class Integral1D {

	static {
		NativeLibraryLoader.loadLibraries();
		initFieldIDs();
	}

	private static native void initFieldIDs() ;

	IntegralFunction1D func ;
	double absErr = 1e-10 ;
	double relErr = 1e-10 ;
	int maxNumberOfIntervals = 100 ;

	/**
	 * Signature of methods: <br>
	 * Q - quadrature routine <br>
	 * N - non-adaptive integrator <br>
	 * A - adaptive integrator <br>
	 * G - general integrand (user-defined) <br>
	 * W - weight function with integrand <br>
	 * S - singularities can be more readily integrated <br>
	 * P - points of special difficulty can be supplied <br>
	 * I - infinite range of integration <br>
	 * O - oscillatory weight function, cos or sin <br>
	 * F - Fourier integral <br>
	 * C - Cauchy principal value
	 *
	 */
	public Integral1D() {
		this.func = null ;
	}

	/**
	 * Signature of methods: <br>
	 * Q - quadrature routine <br>
	 * N - non-adaptive integrator <br>
	 * A - adaptive integrator <br>
	 * G - general integrand (user-defined) <br>
	 * W - weight function with integrand <br>
	 * S - singularities can be more readily integrated <br>
	 * P - points of special difficulty can be supplied <br>
	 * I - infinite range of integration <br>
	 * O - oscillatory weight function, cos or sin <br>
	 * F - Fourier integral <br>
	 * C - Cauchy principal value
	 *
	 * @param func : integral function (integrand)
	 */
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
	public native double[] qagiuWithError(double a) ;
	public native double qagil(double b) ;
	public native double[] qagilWithError(double b) ;

	// QAWC adaptive integration for Cauchy principal values
	public native double qawc(double a, double b, double c) ;
	public native double[] qawcWithError(double a, double b, double c) ;

	// QAWS adaptive integration for singular functions
	public static final int WEIGHT_FUNC_TYPE_I = 100 ;
	public static final int WEIGHT_FUNC_TYPE_II = 101 ;
	public static final int WEIGHT_FUNC_TYPE_III = 102 ;
	public static final int WEIGHT_FUNC_TYPE_IV = 103 ;
	public native double qaws(double a, double b, int weightFuncType, double alpha, double beta) ;
	public native double[] qawsWithError(double a, double b, int weightFuncType, double alpha, double beta) ;

	// QAWO adaptive integration for oscillatory functions
	public static final int GSL_INTEG_COSINE = 0 ;
	public static final int GSL_INTEG_SINE = 1 ;
	public native double qawo(double a, double b, int choice, double omega) ;
	public native double[] qawoWithError(double a, double b, int choice, double omega) ;

	// QAWF adaptive integration for Fourier integrals
	public native double qawf(double a, double b, int choice, double omega) ;

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
