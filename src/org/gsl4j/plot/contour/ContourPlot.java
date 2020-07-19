package org.gsl4j.plot.contour;



/*
 * X, Yarray-like, optional
 * The coordinates of the values in Z.
 * X and Y must both be 2-D with the same shape as Z (e.g. created via numpy.meshgrid), or they must both be 1-D such that len(X) == M is the number of columns in Z and len(Y) == N is the number of rows in Z.
 * If not given, they are assumed to be integer indices, i.e. X = range(M), Y = range(N).
 *
 * Zarray-like(N, M)
 * The height values over which the contour is drawn.
 *
 */


/**
 * matplotlib.pyplot.contour(*args, data=None, **kwargs)
 * contour([X, Y,] Z, [levels], **kwargs)
 *
 * @author Meisam
 *
 */
public class ContourPlot {

	String title = null ;
	String xlabel = null ;
	String ylabel = null ;
	boolean grid = false ;
	boolean cla = false ;
	String gridWhich = null ;
	String gridAxis = null ;
	String xlim = null ;
	String ylim = null ;
	// legend
	boolean legend = false ;
	String legendLocation ;
	// other properties
	boolean tightLayout = false ;
	// xy contour series
	ContourSeries series ;
	// labels
	ContourLabel clabel ;


	public ContourPlot plot() {
		return this ;
	}

	public ContourLabel clabel() {
		return clabel ;
	}




}
