package org.gsl4j.interpolate.oned;

public class PolynomialInterpolation extends Interpolation1D {

	public PolynomialInterpolation(double[] x, double[] y) {
		super(x, y, POLYNOMIAL);
	}

}
