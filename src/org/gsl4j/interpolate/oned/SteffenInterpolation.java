package org.gsl4j.interpolate.oned;

public class SteffenInterpolation extends Interpolation1D {

	public SteffenInterpolation(double[] x, double[] y) {
		super(x, y, STEFFEN);
	}

}
