package org.gsl4j.util;

import java.util.Arrays;

import org.gsl4j.complex.Complex;
import org.gsl4j.function.MathFunction;

public class ArrayUtils {

	private ArrayUtils() {

	}

	public static Complex[] toComplexArray(double[] array) {
		int len = array.length ;
		if(len % 2 == 1) {
			throw new IllegalArgumentException("Array length must be an even integer") ;
		}
		int clen = len/2 ;
		Complex[] complexArray = new Complex[clen] ;
		for(int i=0; i<clen; i++) {
			complexArray[i] = Complex.ofRect(array[2*i], array[2*i+1]) ;
		}
		return complexArray ;
	}

	public static double[] eval(MathFunction func, double[] x) {
		double[] result = new double[x.length] ;
		if(x.length<10000) {
			// single-threaded (sequential)
			result = Arrays.stream(x).map(t -> func.value(t)).toArray() ;
		}
		else {
			// multi-threaded (parallel)
			result = Arrays.stream(x).parallel().map(t -> func.value(t)).toArray() ;
		}
		return result ;
	}

}
