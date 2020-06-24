package org.gsl4j.interpolate.oned;

public class PeriodicCubicSplineInterpolation extends Interpolation1D {

	public PeriodicCubicSplineInterpolation(double[] x, double[] y) {
		super(x, y, CUBIC_SPLINE_PERIODIC);
	}

}
