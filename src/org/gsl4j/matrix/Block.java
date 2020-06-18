package org.gsl4j.matrix;

public class Block {

	int size ;
	double[] data ;

	private Block(double[] data) {
		this.size = data.length ;
		this.data = data ;
	}

	public static Block ofArray(double[] data) {
		return new Block(data) ;
	}

}
