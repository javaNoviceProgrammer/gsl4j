package org.gsl4j.tests;

import org.gsl4j.plot.contour.ContourPlot;
import org.gsl4j.plot.contour.MeshGrid;
import org.gsl4j.util.MathUtils;

class TestContourPlot {

	public static void test1() {
		ContourPlot plt = new ContourPlot("contour plot from java!!!") ;
		double[] x = MathUtils.linspace(0.0, 5.0, 100) ;
		double[] y = MathUtils.linspace(-5.0, 0.0, 20) ;
		MeshGrid func = (xi, yj) -> Math.sin(xi)*Math.cos(yj) ;
		plt.contour(x, y, func) ;
		plt.show();
	}

	public static void main(String[] args) {
		test1() ;
	}

}
