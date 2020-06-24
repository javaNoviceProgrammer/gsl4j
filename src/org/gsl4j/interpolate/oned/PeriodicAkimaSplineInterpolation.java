package org.gsl4j.interpolate.oned;

public class PeriodicAkimaSplineInterpolation extends Interpolation1D {

	public PeriodicAkimaSplineInterpolation(double[] x, double[] y) {
		super(x, y, AKIMA_PERIODIC);
	}

}
