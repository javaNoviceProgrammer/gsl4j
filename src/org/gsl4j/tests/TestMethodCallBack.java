package org.gsl4j.tests;

import org.gsl4j.roots.RealRoot;
import org.gsl4j.roots.RealRootFunction;

public class TestMethodCallBack {

	private static void test1() {
		RealRootFunction func = x -> x*x ;
		double y = RealRoot.func(func, 1.1) ;
		System.out.println(y);
	}

	public static void main(String[] args) {
		test1() ;
	}

}
