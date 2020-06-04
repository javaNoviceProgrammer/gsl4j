package org.gsl4j;

import org.gsl4j.util.NativeLibraryLoader;

public class MathConstants {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private MathConstants() {

	}

	public static final double M_E = me() ;
	public static final double M_LOG2E = mlog2e() ;
	public static final double M_LOG10E = mlog10e() ;
	public static final double M_SQRT2 = msqrt2() ;
	public static final double M_SQRT1_2 = msqrt12() ;
	public static final double M_SQRT3 = msqrt3() ;
	public static final double M_PI = mpi() ;
	public static final double M_PI_2 = mpi2() ;
	public static final double M_PI_4 = mpi4() ;
	public static final double M_SQRTPI = msqrtpi() ;
	public static final double M_2_SQRTPI = m2sqrtpi() ;
	public static final double M_1_PI = m1pi() ;
	public static final double M_2_PI = m2pi() ;
	public static final double M_LN10 = mln10() ;
	public static final double M_LN2 = mln2() ;
	public static final double M_LNPI = mlnpi() ;
	public static final double M_EULER = meuler() ;
	public static final double GSL_POSINF = gslposinf() ;
	public static final double GSL_NEGINF = gslneginf() ;
	public static final double GSL_NAN = gslnan() ;

	private static native double me() ;
	private static native double mlog2e() ;
	private static native double mlog10e() ;
	private static native double msqrt2() ;
	private static native double msqrt12() ;
	private static native double msqrt3() ;
	private static native double mpi() ;
	private static native double mpi2() ;
	private static native double mpi4() ;
	private static native double msqrtpi() ;
	private static native double m2sqrtpi() ;
	private static native double m1pi() ;
	private static native double m2pi() ;
	private static native double mln10() ;
	private static native double mln2() ;
	private static native double mlnpi() ;
	private static native double meuler() ;
	private static native double gslposinf() ;
	private static native double gslneginf() ;
	private static native double gslnan() ;

	public static native boolean isNaN(double x) ;
	public static native boolean isInf(double x) ;
	public static native boolean isPositiveInf(double x) ;
	public static native boolean isNegativeInf(double x) ;
	public static native boolean isFinite(double x) ;

	// precision for special functions
	public static final int GSL_PREC_DOUBLE = 0 ;
	public static final int GSL_PREC_SINGLE = 0 ;
	public static final int GSL_PREC_APPROX = 0 ;

}
