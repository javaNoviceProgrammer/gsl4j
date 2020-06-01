package org.gsl4j.tests;

import java.util.ArrayList;
import java.util.Arrays;

import org.gsl4j.special.AiryFunction;

class TestAiry {

	private static void test1() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		ArrayList<Double> result = new ArrayList<>() ;
		for(double d : x)
			result.add(AiryFunction.ai(d)) ;
		System.out.println(result);
	}

	private static void test2() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		ArrayList<Double> result = new ArrayList<>() ;
		for(double d : x)
			result.add(AiryFunction.aiScaled(d)) ;
		System.out.println(result);
	}

	private static void test3() {
		double x = AiryFunction.aiZero(1) ;
		System.out.println(x);
	}

	private static void test4() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		double[] y = Arrays.stream(x).map(AiryFunction::bi).toArray() ;
		System.out.println(Arrays.toString(y));
	}


	public static void main(String[] args) {
		test1() ;
		test2() ;
		test3() ;
		test4() ;
	}

}
