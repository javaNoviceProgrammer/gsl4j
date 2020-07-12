package org.gsl4j.plot.simple;

import java.io.IOException;
import java.util.ArrayList;
import static java.lang.String.* ;
import org.gsl4j.io.FileOutput;

public class XYPlot {

	String title = null ;
	String xlabel = null ;
	String ylabel = null ;
	boolean grid = false ;
	boolean cla = false ;
	String gridWhich = null ;
	String gridAxis = null ;
	String xlim = null ;
	String ylim = null ;
	ArrayList<XYSeries> xySeriesCollection ;
	int count = 1 ;

	public XYPlot(String title) {
		this.title = title ;
		xySeriesCollection = new ArrayList<>() ;
	}

	public XYPlot() {
		this(null) ;
	}

	public XYPlot xlabel(String xlabel) {
		this.xlabel = xlabel ;
		return this ;
	}

	public XYPlot ylabel(String ylabel) {
		this.ylabel = ylabel ;
		return this ;
	}

	public XYPlot title(String title) {
		this.title = title ;
		return this ;
	}

	public XYPlot xlim(double xmin, double xmax) {
		this.xlim = format("[%f, %f]", xmin, xmax) ;
		return this ;
	}

	public XYPlot ylim(double ymin, double ymax) {
		this.ylim = format("[%f, %f]", ymin, ymax) ;
		return this ;
	}

	public XYPlot grid(boolean on, String which, String axis) {
		this.grid = on ;
		this.gridWhich = which ;
		this.gridAxis = axis ;
		return this ;
	}

	public XYPlot grid(boolean on) {
		this.grid = on ;
		this.gridWhich = "both" ;
		this.gridAxis = "both" ;
		return this ;
	}

	public XYPlot cla() {
		this.cla = true ;
		return this ;
	}

	public XYSeries plot(double[] x, double[] y, String color, String marker, String linestyle, int linewidth, String label) {
		XYSeries xyseries = new XYSeries(x, y, "x"+count, "y"+count, color, marker, linestyle, linewidth, label) ;
		xySeriesCollection.add(xyseries) ;
		++count ;
		return xyseries ;
	}

	public XYSeries plot(double[] x, double[] y) {
		XYSeries xyseries = new XYSeries(x, y, "x"+count, "y"+count, null, null, null, 2, null) ;
		xySeriesCollection.add(xyseries) ;
		++count ;
		return xyseries ;
	}

	public void savefig(String fileName) {
		if(xySeriesCollection.isEmpty())
			throw new IllegalStateException("XYPlot data is empty") ;
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

	public void show(String fileName) {
		if(xySeriesCollection.isEmpty())
			throw new IllegalStateException("XYPlot data is empty") ;
		// open the output stream
		FileOutput fo = new FileOutput(fileName) ;
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
		try {
			rt.exec("python " + fo.getFilename()) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void pythonCode(FileOutput fo) {
		fo.println("from sys import platform as sys_pf") ;
		fo.println("if sys_pf == 'darwin':") ;
		fo.println("\timport matplotlib") ;
		fo.println("\tmatplotlib.use('TkAgg')") ;
		fo.println("import matplotlib.pyplot as plt");
		fo.println();
		// for each xy series, write the data
		for(XYSeries xyseries: xySeriesCollection) {
			// print x
			fo.print(xyseries.xvar + " = [");
			fo.printcomma(xyseries.x);
			fo.print("];") ;
			fo.println();
			// print y
			fo.print(xyseries.yvar + " = [");
			fo.printcomma(xyseries.y);
			fo.print("];") ;
			fo.println();
			// plot
			fo.println(xyseries.toString());
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
	}

}
