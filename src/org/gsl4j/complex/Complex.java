package org.gsl4j.complex;

import org.gsl4j.util.NativeLibraryLoader;

public class Complex {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	public static final Complex ZERO = new Complex(0.0, 0.0) ;
	public static final Complex j = new Complex(0.0, 1.0) ;
	private static int DISPLAY_ACCURACY = 4 ;

	private double re ;
	private double im ;

	private Complex(double re, double im) {
		this.re = re ;
		this.im = im ;
	}

	// copy constructor
	public Complex(Complex z) {
		this.re = z.re ;
		this.im = z.im ;
	}

	public static Complex ofRect(double x, double y) {
		return new Complex(x, y) ;
	}

	public static Complex ofPolar(double r, double phiRad) {
		return new Complex(r*Math.cos(phiRad), r*Math.sin(phiRad)) ;
	}

	public static Complex ofPolarDegree(double r, double phiDegree) {
		return ofPolar(r, Math.toRadians(phiDegree)) ;
	}

	public static Complex ofArray(double...realAndImag) {
		if(realAndImag.length != 2)
			throw new IllegalArgumentException("Number of array elements must be exactly 2") ;
		return ofRect(realAndImag[0], realAndImag[1]) ;
	}

	public double re() {
		return re ;
	}

	public double im() {
		return im ;
	}

	public double[] toArray() {
		return new double[] {re, im} ;
	}

	public static void setDisplayAccuracy(int decimals) {
		DISPLAY_ACCURACY = decimals ;
	}

	@Override
	public String toString() {
		String formatter = "%." + DISPLAY_ACCURACY + "f" ;
		String stReal = String.format(formatter, re) ;
		String stImag = String.format(formatter, Math.abs(im)) ;
		if (im == 0)
			return stReal + "";
		if (re == 0 && im > 0)
			return "j" + stImag;
		if (re == 0 && im < 0)
			return "-j" + stImag;
		if (im < 0)
			return stReal + "-" + "j" + stImag;
		return stReal + "+" + "j" + stImag;
	}


}
