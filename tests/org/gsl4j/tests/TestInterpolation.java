package org.gsl4j.tests;

import org.gsl4j.interpolate.oned.AkimaSplineInterpolation;
import org.gsl4j.interpolate.oned.CubicSplineInterpolation;
import org.gsl4j.interpolate.oned.Interpolation1D;
import org.gsl4j.interpolate.oned.LinearInterpolation;
import org.gsl4j.interpolate.oned.PeriodicAkimaSplineInterpolation;
import org.gsl4j.util.ArrayUtils;
import org.gsl4j.util.MathUtils;


public class TestInterpolation {

	public static void test1() {
		double[] x = MathUtils.linspace(0.0, 1.0, 10) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D linInterp = new LinearInterpolation(x, y) ;
		System.out.println(linInterp.name());
	}

	public static void test2() {
		double[] x = MathUtils.linspace(0.0, 1.0, 1000) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D linInterp = new LinearInterpolation(x, y) ;
		double z = linInterp.eval(0.222222) ;
		System.out.println(z);
		System.out.println(Math.sin(0.222222));
	}

	public static void test3() {
		double[] x = MathUtils.linspace(0.0, 1.0, 10) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D linInterp = new CubicSplineInterpolation(x, y) ;
		System.out.println(linInterp.name());
	}

	public static void test4() {
		double[] x = MathUtils.linspace(0.0, 1.0, 1000) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D cubicSpline = new CubicSplineInterpolation(x, y) ;
		double z = cubicSpline.eval(0.222222) ;
		System.out.println(z);
		System.out.println(Math.sin(0.222222));
	}

	public static void test5() {
		double[] x = MathUtils.linspace(0.0, 1.0, 10) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D linInterp = new AkimaSplineInterpolation(x, y) ;
		System.out.println(linInterp.name());
	}

	public static void test6() {
		double[] x = MathUtils.linspace(0.0, 1.0, 1000) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D cubicSpline = new AkimaSplineInterpolation(x, y) ;
		double z = cubicSpline.eval(0.222222) ;
		System.out.println(z);
		System.out.println(Math.sin(0.222222));
	}

	public static void test7() {
		double[] x = MathUtils.linspace(0.0, 1.0, 10) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D linInterp = new PeriodicAkimaSplineInterpolation(x, y) ;
		System.out.println(linInterp.name());
	}

	public static void test8() {
		double[] x = MathUtils.linspace(0.0, 1.0, 1000) ;
		double[] y = ArrayUtils.eval(t -> Math.sin(t), x) ;
		Interpolation1D cubicSpline = new PeriodicAkimaSplineInterpolation(x, y) ;
		double z = cubicSpline.eval(0.222222) ;
		System.out.println(z);
		System.out.println(Math.sin(0.222222));
	}

	public static void main(String[] args) {
		test1() ;
		test2() ;
		test3() ;
		test4() ;
		test5() ;
		test6() ;
		test7() ;
		test8() ;
	}

}
