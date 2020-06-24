package org.gsl4j.interpolate;

import org.gsl4j.util.NativeLibraryLoader;

public class Interpolation2D {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	public static final int BILINEAR = 0 ;
	public static final int BICUBIC = 1 ;

	double[] x ;
	double[] y ;
	double[] z ;
	int type ;

	public Interpolation2D(double[] x, double[] y, double[] z, int type) {
		this.x = x ;
		this.y = y ;
		this.z = z ;
		this.type = type ;
		cacheData(type) ;
	}

	public Interpolation2D(double[] x, double[] y, double[][] z, int type) {
		this.x = x ;
		this.y = y ;
		this.z = new double[x.length*y.length] ;
		for(int i=0; i<x.length; i++)
			for(int j=0; j<y.length; j++) {
				this.z[i*y.length+j] = z[i][j] ;
			}
		this.type = type ;
		cacheData(type) ;
	}

	private native void cacheData(int type) ;

	public native String name() ;
	public native int minSize() ;

	public native double eval(double x, double y) ;
	public native double derivX(double x, double y) ;
	public native double derivY(double x, double y) ;
	public native double derivXX(double x, double y) ;
	public native double derivYY(double x, double y) ;
	public native double derivXY(double x, double y) ;
	public native double derivYX(double x, double y) ;

	@Override
	public String toString() {
		return name() ;
	}

}
