package org.gsl4j.polynom;

import org.gsl4j.util.NativeLibraryLoader;

public class PolynomialMath {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private PolynomialMath() {

	}

	// Polynomial Evaluation
	public static native double eval(double[] coeffs, double x) ;
	public static native double[] eval(double[] coeffs, double re, double im) ;
	public static native double[] eval(double[] coeffs, double[] re, double[] im) ;
	public static native double[] evalDerivs(double[] coeffs, int n, double x) ;

	// Divided Difference Representation of Polynomials


	// Quadratic Equations
	public static native double[] solveQuadraticRealRoots(double a, double b, double c) ;
	public static native double[] solveQuadraticComplexRoots(double a, double b, double c) ;

	// Cubic Equations
	public static native double[] solveCubicRealRoots(double a, double b, double c) ;
	public static native double[] solveCubicComplexRoots(double a, double b, double c) ;

	// General Polynomial Equations
	public static native double[] solvePolynomialRealRoots(double[] coeffs) ;

}
