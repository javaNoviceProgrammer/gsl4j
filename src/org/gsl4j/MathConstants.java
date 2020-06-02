package org.gsl4j;

import org.gsl4j.util.NativeLibraryLoader;

public class MathConstants {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private MathConstants() {

	}

	public static double M_E = me() ;
	public static double M_LOG2E = mlog2e() ;
	public static double M_LOG10E = mlog10e() ;
	public static double M_SQRT2 = msqrt2() ;
	public static double M_SQRT1_2 = msqrt12() ;
	public static double M_SQRT3 = msqrt3() ;
	public static double M_PI = mpi() ;
	public static double M_PI_2 = mpi2() ;
	public static double M_PI_4 = mpi4() ;
	public static double M_SQRTPI = msqrtpi() ;
	public static double M_2_SQRTPI = m2sqrtpi() ;
	public static double M_1_PI = m1pi() ;
	public static double M_2_PI = m2pi() ;
	public static double M_LN10 = mln10() ;
	public static double M_LN2 = mln2() ;
	public static double M_LNPI = mlnpi() ;
	public static double M_EULER = meuler() ;
	public static double GSL_POSINF = gslposinf() ;
	public static double GSL_NEGINF = gslneginf() ;
	public static double GSL_NAN = gslnan() ;

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


}
