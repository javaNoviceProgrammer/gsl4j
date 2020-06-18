package org.gsl4j.matrix;

public class Vector {

	int size ;
	int stride ;
	Block block ;
	int owner ;
	double[] data ;

	private Vector(double[] data) {
		this.size = data.length ;
		this.data = data ;
	}

	public static Vector ofArray(double[] data) {
		return new Vector(data) ;
	}

}
