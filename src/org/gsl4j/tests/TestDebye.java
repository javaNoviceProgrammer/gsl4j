package org.gsl4j.tests;

import java.util.Arrays;

import org.gsl4j.special.Debye;
import org.gsl4j.util.MathUtils;

public class TestDebye {

	private static void test1() {
		double[] x = MathUtils.linspace(0.0, 10.0, 5) ;
		double[] y = Arrays.stream(x).map(t -> Debye.debye1(t)).toArray() ;
		System.out.println(Arrays.toString(y));
	}

	public static void main(String[] args) {
		test1() ;
	}

}
