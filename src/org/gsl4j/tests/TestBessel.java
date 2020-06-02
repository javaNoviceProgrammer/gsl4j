package org.gsl4j.tests;

import java.util.ArrayList;
import java.util.Arrays;
import org.gsl4j.special.Bessel;

class TestBessel {

	private static void test1() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		ArrayList<Double> result = new ArrayList<>() ;
		for(double d : x)
			result.add(Bessel.J0(d)) ;
		System.out.println(result);
	}

	private static void test2() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		ArrayList<Double> result = new ArrayList<>() ;
		for(double d : x)
			result.add(Bessel.J1(d)) ;
		System.out.println(result);
	}


	private static void test3() {
		double[] x = {-20.0, -15, -2.5, 0.0, 3.2} ;
		double[] y = Arrays.stream(x).map(t -> Bessel.Jn(3, t)).toArray() ;
		System.out.println(Arrays.toString(y));
	}

	private static void test4() {
		double x = 0.0 ;
		double[] y = Bessel.JnArray(0, 10, x) ;
		System.out.println(Arrays.toString(y));
	}

	private static void test5() {
		double x = 2.0 ;
		double[] y = Bessel.YnArray(0, 10, x) ;
		System.out.println(Arrays.toString(y));
	}


	public static void main(String[] args) {
		test1() ;
		test2() ;
		test3() ;
		test4() ;
		test5() ;
	}

}
