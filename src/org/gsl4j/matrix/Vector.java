package org.gsl4j.matrix;

import org.gsl4j.util.NativeLibraryLoader;

public class Vector {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	double[] x ;
	int dim ;

	public Vector(double[] x) {
		this.x = x ;
		this.dim = x.length ;
	}

}
