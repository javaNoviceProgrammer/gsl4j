package org.gsl4j.interpolate.oned;



public class CubicSplineInterpolation extends Interpolation1D {

	public CubicSplineInterpolation(double[] x, double[] y) {
		super(x, y, CUBIC_SPLINE) ;
	}

}
