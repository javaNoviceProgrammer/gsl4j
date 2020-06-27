package org.gsl4j.tests;

import java.util.Arrays;
import org.gsl4j.integration.Integral1D;
import org.gsl4j.integration.IntegralFunction1D;


public class TestIntegral1D {

	public static void test1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qng(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test2() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qngDetailed(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test3() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss15(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test4() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss15withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test5() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss21(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test5_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss21withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test6() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss31(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test6_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss31withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test7() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss41(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test7_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss41withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test8() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss51(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test8_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss51withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test9() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagGauss61(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test9_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagGauss61withError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test10() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qags(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test10_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagsWithError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test11() {
		IntegralFunction1D func = t -> 1.0/(t*t)+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qags(1.1, 2.2) ;
		System.out.println(result);
	}

	public static void test11_1() {
		IntegralFunction1D func = t -> 1.0/(t*t)+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagsWithError(1.1, 2.2) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test12() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagp(1.1, 2.2, new double[] {2.0}) ;
		System.out.println(result);
	}

	public static void test12_1() {
		IntegralFunction1D func = t -> t*t+1.0 ;
		Integral1D integral = new Integral1D(func) ;
		double[] result = integral.qagpWithError(1.1, 2.2, new double[] {2.0}) ;
		System.out.println(Arrays.toString(result));
	}

	public static void test13() {
		IntegralFunction1D func = t -> 1.0/(1.0+t*t*t*t) ;
		Integral1D integral = new Integral1D(func) ;
		double result = integral.qagi() ;
		System.out.println(result);
	}

	public static void main(String[] args) {
//		test1() ;
//		test2() ;
//		test3() ;
//		test4() ;
//		test5() ;
//		test5_1() ;
//		test6() ;
//		test6_1() ;
//		test7() ;
//		test7_1() ;
//		test8() ;
//		test8_1() ;
//		test9() ;
//		test9_1() ;
//		test10() ;
//		test10_1() ;
//		test11() ;
//		test11_1() ;
//		test12() ;
//		test12_1() ;
		test13() ;
	}

}
