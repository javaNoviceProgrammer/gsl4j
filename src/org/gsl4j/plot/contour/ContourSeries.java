package org.gsl4j.plot.contour;

import java.util.Arrays;
import java.util.List;
import static java.lang.String.format;


public class ContourSeries {

	// variables
	double[] x ;
	double[] y ;
	String xvar ;
	String yvar ;
	double[][] z ;
	String zvar ;
	// meshgrid function
	MeshGrid func ;
	// parameters
	boolean cornerMask ;
	double alpha = 1.0 ;
	String colorMap ;
	boolean antialiased ;
	double linewidth = 2.0 ;
	String linestyle ;
	List<String> hatches ;
	String extend ;
	String origin ;
	double[] extent ; // x0, x1, y0, y1
	// labels
	ContourLabel clabel ;


	public ContourSeries(double[] x, double[] y, MeshGrid func) {
		this.x = x ;
		this.y = y ;
		this.func = func ;
		z = new double[y.length][x.length] ;
		for(int i=0; i<y.length; i++)
			for(int j=0; j<x.length; j++)
				z[i][j] = func.value(x[j], y[i]) ;
	}


	public ContourSeries setXData(double[] x) {
		this.x = x ;
		return this ;
	}

	public ContourSeries setYData(double[] y) {
		this.y = y ;
		return this ;
	}

	public ContourSeries setXvar(String xvar) {
		this.xvar = (xvar!=null) ? xvar.trim() : null ;
		return this ;
	}

	public ContourSeries setYvar(String yvar) {
		this.yvar = (yvar!=null) ? yvar.trim() : null ;
		return this ;
	}

	public ContourSeries setZvar(String zvar) {
		this.zvar = (zvar!=null) ? zvar.trim() : null ;
		return this ;
	}


	String getPythonCode() {
		StringBuilder sb = new StringBuilder() ;
		if(func == null)
			throw new IllegalArgumentException("MeshGrid function cannot be NULL") ;
		if(xvar == null)
			throw new IllegalArgumentException("x variable cannot be NULL") ;
		if(yvar == null)
			throw new IllegalArgumentException("x variable cannot be NULL") ;
		// create z data
		sb.append(format("%s, %s = np.meshgrid(%s, %s);\n", xvar.toUpperCase(), yvar.toUpperCase(), xvar, yvar)) ;
		sb.append(format("%s = np.array(%s);\n", zvar.toUpperCase(), Arrays.deepToString(z))) ;
		if(clabel==null || clabel.levels==null)
			sb.append(format("plt.contour(%s, %s, %s)\n", xvar.toUpperCase(), yvar.toUpperCase(), zvar.toUpperCase())) ;
		else
			sb.append(format("plt.contour(%s, %s, %s, levels=%s)\n", xvar.toUpperCase(), yvar.toUpperCase(), zvar.toUpperCase(), Arrays.toString(clabel.levels))) ;

		return sb.toString() ;
	}

	@Override
	public String toString() {
		return getPythonCode() ;
	}


	public static void main(String[] args) {
		double[] x = {1.1, 2.2, 3.3} ;
		double[] y = {-1.0, -2.0, -3.0, -4.0} ;
		ContourSeries series = new ContourSeries(x, y, (z,w)->z*w) ;
		series.setXvar("x1").setYvar("y1").setZvar("z1") ;
//		System.out.println(Arrays.deepToString(series.z));
		System.out.println(series);
	}


}
