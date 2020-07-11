package org.gsl4j.tests;

import java.io.IOException;
import java.util.Arrays;

import org.gsl4j.plot.Plot;
import org.gsl4j.plot.PythonExecutionException;

public class TestMatplotlib4j {

	public static void test1() {
		Plot plt = Plot.create();
		plt.plot()
		    .add(Arrays.asList(1.3, 2))
		    .label("label")
		    .color("b")
		    .linestyle("--");
		plt.xlabel("xlabel");
		plt.ylabel("ylabel");
		plt.text(0.5, 0.2, "text");
		plt.title("Title!");
		plt.legend();
		try {
			plt.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PythonExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		test1() ;
	}

}
