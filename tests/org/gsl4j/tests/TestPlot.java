package org.gsl4j.tests;

import java.util.Arrays;
import org.gsl4j.plot.XYPlot;
import org.gsl4j.plot.XYSeries;
import org.gsl4j.util.MathUtils;

public class TestPlot {

	public static void test1() {
		XYSeries xyseries = new XYSeries(null, null, "x1", "y1", null, "o", 2, null) ;
		System.out.println(xyseries);
	}

	public static void test2() {
		XYPlot fig = new XYPlot() ;
		System.out.println(fig.plot(new double[] {1.0, 2.0}, new double[] {3.0, 4.0})
								.setLabel("this is my test!!")
								.setColor("b")
				);

	}

	public static void test3() {
		XYPlot fig = new XYPlot() ;
		fig.plot(new double[] {1.1, 2.2}, new double[] {3.3, 4.4}) ;
		fig.run();
	}

	public static void test4() {
		XYPlot fig = new XYPlot() ;
		double[] x = MathUtils.linspace(-Math.PI, Math.PI, 1000) ;
		double[] y = Arrays.stream(x).map(Math::cos).toArray() ;
		fig.plot(x, y).setColor("r") ;
		fig.xlabel("x values");
		fig.ylabel("y values");
		fig.grid(true, "major", "both");
		fig.run();
	}

	public static void main(String[] args) {
//		test1() ;
//		test2() ;
//		test3() ;
		test4() ;
	}

}
