package org.gsl4j.plot.contour;

import static java.lang.String.format;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.gsl4j.io.FileOutput;
import org.gsl4j.plot.style.LegendLocation;


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
	// contour series
	ArrayList<ContourSeries> contourSeriesCollection ;
	int count = 1 ;


	public ContourPlot(String title) {
		this.title = title ;
		contourSeriesCollection = new ArrayList<>() ;
	}


	public ContourSeries contour(double[] x, double[] y, MeshGrid func) {
		ContourSeries series = new ContourSeries(x, y, func) ;
		series.setXvar("x"+count).setYvar("y"+count).setZvar("z"+count) ;
		contourSeriesCollection.add(series) ;
		count++ ;
		return series ;
	}


	public ContourPlot xlabel(String xlabel) {
		this.xlabel = xlabel ;
		return this ;
	}

	public ContourPlot ylabel(String ylabel) {
		this.ylabel = ylabel ;
		return this ;
	}

	public ContourPlot title(String title) {
		this.title = title ;
		return this ;
	}

	public ContourPlot xlim(double xmin, double xmax) {
		this.xlim = format("[%f, %f]", xmin, xmax) ;
		return this ;
	}

	public ContourPlot ylim(double ymin, double ymax) {
		this.ylim = format("[%f, %f]", ymin, ymax) ;
		return this ;
	}

	public ContourPlot grid(boolean on, String which, String axis) {
		this.grid = on ;
		this.gridWhich = which ;
		this.gridAxis = axis ;
		return this ;
	}

	public ContourPlot grid(boolean on) {
		this.grid = on ;
		this.gridWhich = "both" ;
		this.gridAxis = "both" ;
		return this ;
	}

	public ContourPlot legend(boolean on) {
		this.legend = on ;
		return this ;
	}

	public ContourPlot legend(boolean on, String loc) {
		this.legend = on ;
		this.legendLocation = (loc!=null) ? loc.trim() : null ;
		return this ;
	}

	public ContourPlot legend(boolean on, LegendLocation loc) {
		this.legend = on ;
		this.legendLocation = (loc!=null) ? loc.toString().trim() : null ;
		return this ;
	}

	public ContourPlot tightLayout() {
		this.tightLayout = true ;
		return this ;
	}

	public ContourPlot cla() {
		this.cla = true ;
		return this ;
	}


	public void savefig(String fileName) {
		if(contourSeriesCollection.isEmpty())
			throw new IllegalStateException("ContourPlot data is empty") ;
		// open the output stream
		int index = fileName.lastIndexOf('.') ;
		String pyName = fileName.substring(0, index) ;
		FileOutput fo = new FileOutput(pyName+".py") ;
		pythonCode(fo);
		// show the plot
		if(cla) {
			fo.println("plt.cla()");
		}
		fo.println(format("plt.savefig('%s')", fileName));
		// close the output stream
		fo.close();
		// run the python code
		Runtime rt = Runtime.getRuntime() ;
		try {
			rt.exec("python " + fo.getFilename()) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void show() {
		// open the output stream
		File file = new File("fig") ;
//		file.deleteOnExit();
		FileOutput fo = new FileOutput(file) ;
		pythonCode(fo);
		// show the plot
		if(cla) {
			fo.println("plt.cla()");
		}
		fo.println("plt.show()");
		// close the output stream
		fo.close();
		// run the python code
		Runtime rt = Runtime.getRuntime() ;
		Process process ;
		try {
			process = rt.exec("python " + fo.getFilename()) ;
			while(true) {
				if(!process.isAlive()) {
					if(file.exists())
						file.delete() ;
					System.out.println("clean up completed.");
					break ;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void pythonCode(FileOutput fo) {
		fo.println("from sys import platform as sys_pf") ;
		fo.println("if sys_pf == 'darwin':") ;
		fo.println("\timport numpy as np") ;
		fo.println("\timport matplotlib") ;
		fo.println("\tmatplotlib.use('TkAgg')") ;
		fo.println("import matplotlib.pyplot as plt");
		fo.println();
		// print x and y values
		for(ContourSeries contourSeries : contourSeriesCollection) {
			// print x
			fo.print(contourSeries.xvar + " = [");
			fo.printcomma(contourSeries.x);
			fo.print("];") ;
			fo.println();
			// print y
			fo.print(contourSeries.yvar + " = [");
			fo.printcomma(contourSeries.y);
			fo.print("];") ;
			fo.println();
			// plot
			fo.println(contourSeries.toString());
		}
		// configure the plot
		if(title != null)
			fo.println(format("plt.title('%s')", title)) ;
		if(xlabel != null)
			fo.println(format("plt.xlabel('%s')", xlabel)) ;
		if(ylabel != null)
			fo.println(format("plt.ylabel('%s')", ylabel)) ;
		if(xlim != null)
			fo.println(format("plt.xlim(%s)", xlim));
		if(ylim != null)
			fo.println(format("plt.ylim(%s)", ylim));
		if(grid)
			fo.println(format("plt.grid(%s, which='%s', axis='%s')", "True", gridWhich, gridAxis)) ;
		else
			fo.println(format("plt.grid(%s, which='%s', axis='%s')", "False", gridWhich, gridAxis)) ;
		if(legend) {
			if(legendLocation != null)
				fo.println(format("plt.legend(loc='%s')", legendLocation)) ;
			else
				fo.println("plt.legend()");
		}

		if(tightLayout)
			fo.println("plt.tight_layout()");

	}

}
