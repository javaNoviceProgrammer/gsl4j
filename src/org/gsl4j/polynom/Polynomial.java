package org.gsl4j.polynom;

import org.gsl4j.util.NativeLibraryLoader;

public class Polynomial {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	double[] coeffs ;

	private Polynomial(double[] coeffs) {
		this.coeffs = coeffs ;
	}

	public static Polynomial of(Polynomial p) {
		return new Polynomial(p.coeffs) ;
	}

	public static Polynomial ofCoeffs(double[] coeffs) {
		return new Polynomial(coeffs) ;
	}

}
