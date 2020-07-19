package org.gsl4j.plot.contour;

import java.util.List;

public class ContourSeries {

	// variables
	double[] x ;
	double[] y ;
	String xvar ;
	String yvar ;
	// meshgrid function
	MeshGrid meshgrid ;
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

	// m = x.length
	// n = y.length
	// X, Y = np.meshgrid(x, y)
	// z = np.zeros([n, m])


	String getPythonCode() {
		StringBuilder sb = new StringBuilder() ;

		return sb.toString() ;
	}

	@Override
	public String toString() {
		return getPythonCode() ;
	}



}
