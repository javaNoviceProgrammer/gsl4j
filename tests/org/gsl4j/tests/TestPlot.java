package org.gsl4j.tests;

import java.util.Arrays;

import org.gsl4j.plot.simple.XYPlot;
import org.gsl4j.plot.simple.XYSeries;
import org.gsl4j.util.MathUtils;


public class TestPlot {

	public static void test1() {
		XYSeries xyseries = new XYSeries(null, null, "x1", "y1", null, "o", null, 2, null) ;
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
		fig.show("./tests/org/gsl4j/tests/test/fig.py");
	}

	public static void test4() {
		XYPlot fig = new XYPlot() ;
		double[] x = MathUtils.linspace(-Math.PI, Math.PI, 200) ;
		double[] y = Arrays.stream(x).map(Math::cos).toArray() ;
		fig.plot(x, y).setColor("b").setLinewidth(4).setLinestyle("-") ;
		fig.xlabel("x values");
		fig.ylabel("y values");
		fig.xlim(-10.0, 10.0);
		fig.grid(true, "both", "both");
		fig.show("./tests/org/gsl4j/tests/test/fig.py");
	}

	public static void test5() {
		XYPlot fig = new XYPlot() ;
		double[] x = MathUtils.linspace(-Math.PI, Math.PI, 200) ;
		double[] y = Arrays.stream(x).map(Math::cos).toArray() ;
		fig.plot(x, y).color("r").linewidth(5).linestyle("-") ;
		fig.xlabel("x values");
		fig.ylabel("y values");
		fig.grid(true, "both", "both");
		fig.title("My first plot from java!!!! :)");
		fig.savefig("./tests/org/gsl4j/tests/test/fig1.png");
	}

	public static void test6() {
		XYPlot fig = new XYPlot() ;
		double[] t = MathUtils.linspace(0.0, 2.0*Math.PI, 200) ;
		double[] x = Arrays.stream(t).map(Math::cos).toArray() ;
		double[] y = Arrays.stream(t).map(Math::sin).toArray() ;
		fig.plot(x, y).color("b").linewidth(2).linestyle("-") ;
		fig.xlabel("X");
		fig.ylabel("Y");
		fig.grid(true, "both", "both");
		fig.savefig("./tests/org/gsl4j/tests/test/fig2.png");
	}

	public static void main(String[] args) {
//		test1() ;
//		test2() ;
//		test3() ;
		test4() ;
//		test5() ;
//		test6() ;
	}

}
