package org.gsl4j.tests;

import org.gsl4j.special.Digamma;

public class TestDigamma {

	private static void test1() {
		double x = 1.1 ;
		double y = Digamma.digamma(x) ;
		System.out.println(y);
	}

	private static void test2() {
		double x = 1.1 ;
		double y = Digamma.polygamma(2, x) ;
		System.out.println(y);
	}

	private static void test3() {
		double x = 1.1 ;
		double y = Digamma.trigamma(x) ;
		System.out.println(y);
	}

	public static void main(String[] args) {
		test1() ;
		test2() ;
		test3() ;
	}

}
