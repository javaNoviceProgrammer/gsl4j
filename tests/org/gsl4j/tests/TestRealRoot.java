package org.gsl4j.tests;

import org.gsl4j.roots.RealRoot;
import org.gsl4j.roots.RealRootFunction;

public class TestRealRoot {

	public static void test1() {
		RealRootFunction func = t -> t*t*t+1.1 ;
		RealRoot rootFinder = new RealRoot(func) ;
		System.out.println("bisection = " + rootFinder.bisection(-10.0, 2.0));
	}

	public static void test2() {
		RealRootFunction func = t -> t*t*t+1.1 ;
		RealRoot rootFinder = new RealRoot(func) ;
		System.out.println("False position = " + rootFinder.falsepos(-10.0, 2.0));
	}

	public static void test3() {
		RealRootFunction func = t -> t*t*t+1.1 ;
		RealRoot rootFinder = new RealRoot(func) ;
		System.out.println("brent = " + rootFinder.brent(-10.0, 2.0));
	}


	public static void main(String[] args) {
		test1() ;
		test2() ;
		test3() ;
	}

}
