package org.gsl4j.tests;

import java.util.Arrays;

import org.gsl4j.plot.polar.PolarPlot;
import org.gsl4j.plot.style.LegendLocation;
import org.gsl4j.util.MathUtils;

class TestPolarPlot {

	public static void test1() {
		double[] r = MathUtils.linspace(0.0, 10.0, 1000) ;
		double[] theta = Arrays.stream(r).map(Math::cos).toArray() ;
		double[] phi = Arrays.stream(r).map(Math::sin).toArray() ;
		PolarPlot plt = new PolarPlot("Polar plot from java!!!!") ;
		plt.plot(r, theta).color("b").linewidth(2).label("sin(r)");
		plt.plot(r, phi).color("r").linewidth(2).linestyle("--").label("cos(r)") ;
		plt.legend(true, LegendLocation.upperRight) ;
		plt.grid(true) ;
		plt.show();
//		plt.savefig(System.getProperty("user.home")+"/Desktop/fig2.pdf");

	}

	public static void main(String[] args) {
		test1() ;
	}

}
