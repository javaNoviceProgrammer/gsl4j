package org.gsl4j.ode;

@FunctionalInterface
public interface DerivnJacobian {

	double[][] values(double x, double... y) ;

}
