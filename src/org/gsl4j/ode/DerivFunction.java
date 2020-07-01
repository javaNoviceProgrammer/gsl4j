package org.gsl4j.ode;

@FunctionalInterface
public interface DerivFunction {
	double value(double x, double y) ; // y' = f(x,y)
}
