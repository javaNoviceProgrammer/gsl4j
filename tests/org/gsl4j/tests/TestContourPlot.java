package org.gsl4j.tests;

import org.gsl4j.plot.contour.ContourPlot;
import org.gsl4j.plot.contour.MeshGrid;
import org.gsl4j.plot.style.ColorMap;
import org.gsl4j.plot.style.LineStyle;
import org.gsl4j.util.MathUtils;

class TestContourPlot {

	public static void test1() {
		ContourPlot plt = new ContourPlot("contour plot from java!!!") ;
		double[] x = MathUtils.linspace(0.0, 5.0, 100) ;
		double[] y = MathUtils.linspace(-5.0, 0.0, 500) ;
		MeshGrid func = (xi, yj) -> Math.sin(xi)*Math.cos(yj) ;
		plt.contour(x, y, func) ;
		plt.clabel().color("r").levels(MathUtils.linspace(-1.0, 1.0, 20))
		   .fontsize(11).inlineSpacing(0.0).fmt("%.2f")
		   .manual(false).rightsideUp(true)
		   .useClabelText(false);
		plt.xlabel("X values") ;
		plt.ylabel("Y vales") ;
		plt.grid(true, "both", "both") ;
		plt.title("f(x) = sin(x)cos(y)") ;
		plt.tightLayout() ;
		plt.show();
	}

	public static void test2() {
		ContourPlot plt = new ContourPlot("contour plot from java!!!") ;
		double[] x = MathUtils.linspace(0.0, 5.0, 100) ;
		double[] y = MathUtils.linspace(-5.0, 0.0, 500) ;
		MeshGrid func = (xi, yj) -> Math.sin(xi)*Math.cos(yj) ;
		plt.contour(x, y, func).alpha(1.0)
		   .linewidth(2.0).linestyle(LineStyle.solid)
		   .antialiased(true).cmap(ColorMap.twilight) ;
		plt.clabel().color("k").levels(MathUtils.linspace(-1.0, 1.0, 20))
		   .fontsize(11).inlineSpacing(0.0).fmt("%.2f")
		   .manual(false).rightsideUp(true)
		   .useClabelText(false);
		plt.xlabel("X values") ;
		plt.ylabel("Y vales") ;
		plt.grid(true, "both", "both") ;
		plt.title("f(x) = sin(x)cos(y)") ;
		plt.tightLayout() ;
		plt.show();
//		plt.savefig("/Users/meisam/Desktop/fig2.png");
	}

	public static void main(String[] args) {
//		test1() ;
		test2() ;
	}

}
