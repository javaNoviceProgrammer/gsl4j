package org.gsl4j.complex;

import java.io.Serializable;

import org.gsl4j.OperatorOverloading;
import org.gsl4j.util.NativeLibraryLoader;

/**
 * Complex numbers are represented using the type {@code gsl_complex}.
 * The internal representation of this type may vary across platforms
 * and should not be accessed directly. The functions and macros described
 * below allow complex numbers to be manipulated in a portable way.
 * @author Meisam
 *
 */
public class Complex implements Serializable, OperatorOverloading<Complex> {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private static final long serialVersionUID = -5423139577060070132L;

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
	private Complex(Complex z) {
		this.re = z.re ;
		this.im = z.im ;
	}

	/**
	 * The real and imaginary part are stored in contiguous elements of a two element array. This eliminates any padding between the real and imaginary parts, dat[0] and dat[1],
	 * allowing the struct to be mapped correctly onto packed complex arrays.
	 * @param z : complex number to be copied
	 * @return {@code Complex} : a new complex number
	 */
	public static Complex of(Complex z) {
		return ofRect(z.re, z.im) ;
	}

	/**
	 * This function uses the rectangular Cartesian components (x,y) to return the complex number z = x + i y.
	 * @param x : real part
	 * @param y : imaginary part
	 * @return {@code Complex} : a new complex number
	 */
	public static Complex ofRect(double x, double y) {
		return new Complex(x, y) ;
	}

	/**
	 * This function returns the complex number z = r \exp(i \theta) = r (\cos(\theta) + i \sin(\theta)) from the polar representation (r, theta).
	 * @param r : magnitude of the complex number |z|
	 * @param phiRad : phase (arg) of the complex number arg(z)
	 * @return
	 */
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

	/**
	 * Real part of z: Re(z)
	 * @return real part of a complex number.
	 */
	public double re() {
		return re ;
	}

	/**
	 * Imaginary part of z: Im(z)
	 * @return imaginary part of a complex number.
	 */
	public double im() {
		return im ;
	}

	public double[] toArray() {
		return new double[] {re, im} ;
	}

	public double[] toArrayPolar() {
		double r = ComplexMath.abs(re, im) ;
		double theta = ComplexMath.arg(re, im) ;
		return new double[] {r, theta} ;
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

	//*********** support for operator overloading *************

	@Override
	public Complex add(double v) {
		return ofRect(re+v, im) ;
	}

	@Override
	public Complex addRev(double v) {
		return ofRect(v+re, im) ;
	}

	@Override
	public Complex add(Complex v) {
		return ofRect(this.re+v.re, this.im+v.im) ;
	}

	@Override
	public Complex addRev(Complex v) {
		return ofRect(v.re+this.re, v.im+this.im) ;
	}

	@Override
	public Complex subtract(double v) {
		return ofRect(re-v, im) ;
	}

	@Override
	public Complex subtractRev(double v) {
		return ofRect(v-re, -im) ;
	}

	@Override
	public Complex subtract(Complex v) {
		return ofRect(this.re-v.re, this.im-v.im) ;
	}

	@Override
	public Complex subtractRev(Complex v) {
		return ofRect(v.re-this.re, v.im-this.im) ;
	}

	@Override
	public Complex multiply(double v) {
		return ofRect(v*re, v*im) ;
	}

	@Override
	public Complex multiplyRev(double v) {
		return ofRect(v*re, v*im) ;
	}

	@Override
	public Complex multiply(Complex v) {
		return ofArray(ComplexMath.mul(re, im, v.re, v.im)) ;
	}

	@Override
	public Complex multiplyRev(Complex v) {
		return ofArray(ComplexMath.mul(v.re, v.im, re, im)) ;
	}

	@Override
	public Complex divide(double v) {
		return ofRect(re/v, im/v) ;
	}

	@Override
	public Complex divideRev(double v) {
		return ofArray(ComplexMath.div(v, 0.0, re, im)) ;
	}

	@Override
	public Complex divide(Complex v) {
		return ofArray(ComplexMath.div(this.re, this.im, v.re, v.im)) ;
	}

	@Override
	public Complex divideRev(Complex v) {
		return ofArray(ComplexMath.div(v.re, v.im, this.re, this.im)) ;
	}

	@Override
	public Complex negate() {
		return ofRect(-re, -im) ;
	}


}
