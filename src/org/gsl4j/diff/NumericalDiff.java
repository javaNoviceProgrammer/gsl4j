package org.gsl4j.diff;

import org.gsl4j.function.MathFunction;
import org.gsl4j.util.NativeLibraryLoader;

/**
 * The functions described in this chapter compute numerical derivatives by finite differencing. An adaptive algorithm is used to find the best choice of finite difference and to estimate the error in the derivative. These functions are declared in the header file {@code gsl_deriv.h}.
 * @author Meisam
 *
 */
public class NumericalDiff {

	static {
		NativeLibraryLoader.loadLibraries();
		initIDs() ;
	}

	private NumericalDiff() {

	}

	private static native void initIDs() ;

	public static native double central(MathFunction func, double x, double h) ;
	public static native double forward(MathFunction func, double x, double h) ;
	public static native double backward(MathFunction func, double x, double h) ;

	public static native double[] centralWithError(MathFunction func, double x, double h) ;
	public static native double[] forwardWithError(MathFunction func, double x, double h) ;
	public static native double[] backwardWithError(MathFunction func, double x, double h) ;

}
