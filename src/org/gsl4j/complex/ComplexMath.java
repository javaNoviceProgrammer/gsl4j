package org.gsl4j.complex;

import org.gsl4j.util.NativeLibraryLoader;


/**
 * The functions described in this class provide support for complex numbers. The algorithms take care to avoid unnecessary intermediate underflows and overflows, allowing the functions to be evaluated over as much of the complex plane as possible.
 * For multiple-valued functions the branch cuts have been chosen
 * to follow the conventions of Abramowitz and Stegun. The functions return principal values which are the same as those in GNU Calc, which in turn are the same as those in
 * “Common Lisp, The Language (Second Edition)” and the HP-28/48 series of calculators.
 *
 * @author Meisam
 *
 */
public class ComplexMath {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private ComplexMath() {

	}

	// Properties of complex numbers
	public static native double arg(double re, double im) ;
	public static native double abs(double re, double im) ;
	public static native double abs2(double re, double im) ;
	public static native double logabs(double re, double im) ;

	// Complex arithmetic operators
	public static native double[] add(double re1, double im1, double re2, double im2) ;
	public static native double[] sub(double re1, double im1, double re2, double im2) ;
	public static native double[] mul(double re1, double im1, double re2, double im2) ;
	public static native double[] div(double re1, double im1, double re2, double im2) ;
	public static native double[] addReal(double re1, double im1, double a) ;
	public static native double[] subReal(double re1, double im1, double a) ;
	public static native double[] mulReal(double re1, double im1, double a) ;
	public static native double[] divReal(double re1, double im1, double a) ;
	public static native double[] addImag(double re1, double im1, double a) ;
	public static native double[] subImag(double re1, double im1, double a) ;
	public static native double[] mulImag(double re1, double im1, double a) ;
	public static native double[] divImag(double re1, double im1, double a) ;
	public static native double[] conjugate(double re, double im) ;
	public static native double[] inverse(double re, double im) ;
	public static native double[] negative(double re, double im) ;

	// Elementary Complex Functions
	public static native double[] sqrt(double re, double im) ;
	public static native double[] sqrtReal(double x) ;
	public static native double[] pow(double re1, double im1, double re2, double im2) ;
	public static native double[] powReal(double re, double im, double x) ;
	public static native double[] exp(double re, double im) ;
	public static native double[] log(double re, double im) ;
	public static native double[] log10(double re, double im) ;
	public static native double[] logb(double re1, double im1, double re2, double im2) ;

	// Complex Trigonometric Functions
	public static native double[] sin(double re, double im) ;
	public static native double[] cos(double re, double im) ;
	public static native double[] tan(double re, double im) ;
	public static native double[] sec(double re, double im) ;
	public static native double[] csc(double re, double im) ;
	public static native double[] cot(double re, double im) ;

	// Inverse Complex Trigonometric Functions
	public static native double[] arcsin(double re, double im) ;
	public static native double[] arcsinReal(double x) ;
	public static native double[] arccos(double re, double im) ;
	public static native double[] arccosReal(double x) ;
	public static native double[] arctan(double re, double im) ;
	public static native double[] arcsec(double re, double im) ;
	public static native double[] arcsecReal(double x) ;
	public static native double[] arccsc(double re, double im) ;
	public static native double[] arccscReal(double x) ;
	public static native double[] arccot(double re, double im) ;

	// Complex Hyperbolic Functions
	public static native double[] sinh(double re, double im) ;
	public static native double[] cosh(double re, double im) ;
	public static native double[] tanh(double re, double im) ;
	public static native double[] sech(double re, double im) ;
	public static native double[] csch(double re, double im) ;
	public static native double[] coth(double re, double im) ;

	// Inverse Complex Hyperbolic Functions
	public static native double[] arcsinh(double re, double im) ;
	public static native double[] arccosh(double re, double im) ;
	public static native double[] arccoshReal(double x) ;
	public static native double[] arctanh(double re, double im) ;
	public static native double[] arctanhReal(double x) ;
	public static native double[] arcsech(double re, double im) ;
	public static native double[] arccsch(double re, double im) ;
	public static native double[] arccoth(double re, double im) ;



}
