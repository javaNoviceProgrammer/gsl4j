package org.gsl4j.ode;

@FunctionalInterface
public interface DerivnFunction {
	double[] values(double x, double... y) ; // represents n-dimensional array f_1, f_2, ..., f_n
}
