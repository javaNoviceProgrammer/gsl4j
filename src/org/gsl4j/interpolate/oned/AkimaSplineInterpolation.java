package org.gsl4j.interpolate.oned;

public class AkimaSplineInterpolation extends Interpolation1D {

	public AkimaSplineInterpolation(double[] x, double[] y) {
		super(x, y, AKIMA);
	}



}
