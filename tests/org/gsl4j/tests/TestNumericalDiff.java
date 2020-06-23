package org.gsl4j.tests;

import java.util.Arrays;
import java.util.function.Function;

import org.gsl4j.diff.NumericalDiff;
import org.gsl4j.function.MathFunction;

public class TestNumericalDiff {

	public static void test1() {
		MathFunction func = t -> Math.sin(t) ;
		double diff = NumericalDiff.central(func, 1.1, 0.1) ;
		System.out.println(diff);
	}

	public static void test2() {
		MathFunction func = t -> Math.sin(t) ;
		double diff = NumericalDiff.forward(func, 1.1, 0.1) ;
		System.out.println(diff);
	}

	public static void test3() {
		MathFunction func = t -> Math.sin(t) ;
		double diff = NumericalDiff.backward(func, 1.1, 0.1) ;
		System.out.println(diff);
	}

	public static void test4() {
		MathFunction func = t -> Math.sin(t) ;
		double[] diff = NumericalDiff.centralWithError(func, 1.1, 0.1) ;
		System.out.println(Arrays.toString(diff));
	}

	public static void test5() {
		MathFunction func = t -> Math.sin(t) ;
		double[] diff = NumericalDiff.forwardWithError(func, 1.1, 0.1) ;
		System.out.println(Arrays.toString(diff));
	}

	public static void test6() {
		MathFunction func = t -> Math.sin(t) ;
		double[] diff = NumericalDiff.backwardWithError(func, 1.1, 0.1) ;
		System.out.println(Arrays.toString(diff));
	}

	public static void test7() {
		Function<Double, Double> func = t -> Math.sin(t) ;
		double[] diff = NumericalDiff.backwardWithError(func::apply, 1.1, 0.1) ;
		System.out.println(Arrays.toString(diff));
	}

	public static void test8() {
		double[] diff = NumericalDiff.backwardWithError(Math::sin, 1.1, 0.1) ;
		System.out.println(Arrays.toString(diff));
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
