package org.gsl4j.plot;

import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gsl4j.io.FileOutput;
import org.gsl4j.plot.contour.ContourPlot;
import org.gsl4j.plot.contour.MeshGrid;
import org.gsl4j.plot.polar.PolarPlot;
import org.gsl4j.plot.xy.XYPlot;



public class Plot {

	boolean tightLayout = false ;


	// data
	List<XYPlot> xyplotSeries;
	List<ContourPlot> contourplotSeries;
	List<PolarPlot> polarplotSeries;
	// file index
	static int id = 0 ;


	public Plot() {
		xyplotSeries = new ArrayList<>() ;
		contourplotSeries = new ArrayList<>() ;
		polarplotSeries = new ArrayList<>() ;
	}

	public XYPlot plot(double[] x, double[] y) {
		if(xyplotSeries.isEmpty()) {
			XYPlot xyplot = new XYPlot() ;
			xyplot.plot(x, y) ;
			xyplot.isSubplot = true ;
			xyplotSeries.add(xyplot) ;
		}
		return xyplotSeries.get(0) ;
	}

	public ContourPlot contour(double[] x, double[] y, MeshGrid z) {
		if(contourplotSeries.isEmpty()) {
			ContourPlot contourplot = new ContourPlot() ;
			contourplot.contour(x, y, z) ;
			contourplot.isSubplot = true ;
			contourplotSeries.add(contourplot) ;
		}
		return contourplotSeries.get(0) ;
	}


	public Plot tightLayout() {
		this.tightLayout = true;
		return this;
	}

	public void savefig(String fileName) {
		if (xyplotSeries.isEmpty())
			throw new IllegalStateException("SubPlots data is empty");
		// open the output stream
		int index = fileName.lastIndexOf('.');
		String pyName = fileName.substring(0, index);
		FileOutput fo = new FileOutput(pyName + ".py");
		pythonCode(fo);
		// save fig
		fo.println(format("plt.savefig('%s')", fileName));
		// close the output stream
		fo.close();
		// run the python code
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("python " + fo.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void show(String fileName) {
		if (xyplotSeries.isEmpty())
			throw new IllegalStateException("SubPlots data is empty");
		// open the output stream
		FileOutput fo = new FileOutput(fileName);
		pythonCode(fo);
		// show the plot
		fo.println("plt.show()");
		// close the output stream
		fo.close();
		// run the python code
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("python " + fo.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void show() {
		if (xyplotSeries.isEmpty())
			throw new IllegalStateException("SubPlots data is empty");
		// open the output stream
		File file = new File("fig" + (id++));
		file.deleteOnExit();
		FileOutput fo = new FileOutput(file);
		pythonCode(fo);
		fo.println("plt.show()");
		// close the output stream
		fo.close();
		// run the python code
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("python " + fo.getFilename());
			Thread.sleep(100L);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void pythonCode(FileOutput fo) {

	}

}
