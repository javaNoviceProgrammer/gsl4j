package org.gsl4j.tests;

import java.util.Arrays;

import org.gsl4j.plot.XYPlot;
import org.gsl4j.plot.XYSeries;
import org.gsl4j.plot.style.CapStyle;
import org.gsl4j.plot.style.DrawStyle;
import org.gsl4j.plot.style.JoinStyle;
import org.gsl4j.plot.style.LineStyle;
import org.gsl4j.util.MathUtils;


public class TestPlot {

	public static void test1() {
		XYSeries xyseries = new XYSeries(null, null, "x1", "y1", null, "o", 0, null, 2, null) ;
		System.out.println(xyseries);
	}

	public static void test2() {
		XYPlot fig = new XYPlot() ;
		System.out.println(fig.plot(new double[] {1.0, 2.0}, new double[] {3.0, 4.0})
								.label("this is my test!!")
								.color("b")
								.linewidth(0)
								.marker("s")
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
		fig.plot(x, y).color("b").linewidth(4).linestyle("-") ;
		fig.xlabel("x values");
		fig.ylabel("y values");
		fig.xlim(-10.0, 10.0);
		fig.grid(true, "both", "both");
		fig.cla() ;
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
//		fig.savefig("./tests/org/gsl4j/tests/test/fig2.png");
		fig.show("./tests/org/gsl4j/tests/test/fig2");
	}

	public static void test7() {
		XYPlot fig = new XYPlot() ;
		fig.help();
	}

	public static void test8() {
		XYPlot fig = new XYPlot() ;
		double[] x = MathUtils.linspace(0.5, Math.PI, 100) ;
		double[] y = Arrays.stream(x).map(Math::cos).map(Math::abs).toArray() ;
		fig.plot(x, y).color("b")//.linewidth(1).linestyle(":")
					  .linestyle(LineStyle.solid).linewidth(4)
//					  .marker(Marker.circle).markerSize(6)
//					  .marker("o").markerSize(10)
//					  .markerEdgeColor("k").markerEdgeWidth(0.5)
//					  .markerFaceColor("y")
//					  .fillstyle(FillStyle.bottom)
					  .label("XY data")
					  .drawstyle(DrawStyle.defaults)
					  .solidCapStyle(CapStyle.round)
					  .solidJoinStyle(JoinStyle.bevel);
//		fig.semilogx(x, y).color("b").linewidth(2).linestyle("-") ;
//		fig.semilogy(x, y).color("b").linewidth(2).linestyle(":") ;
//		fig.loglog(x, y).color("b").linewidth(2).linestyle(":") ;
		fig.xlabel("x values");
		fig.ylabel("y values");
		fig.grid(true, "both", "both");
		fig.title("My first plot from java!!!! :)");
		fig.legend(true) ;
		fig.tightLayout() ;
		fig.show();
	}

	public static void main(String[] args) {
//		test1() ;
//		test2() ;
//		test3() ;
//		test4() ;
//		test5() ;
//		test6() ;
//		test7() ;
		test8() ;
	}

}
