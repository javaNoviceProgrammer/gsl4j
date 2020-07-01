package org.gsl4j.ode;

import org.gsl4j.util.NativeLibraryLoader;

public class OdeSolver {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	DerivFunction func ;
	double x0 ;
	double y0 ;
	double absErr = 1e-6 ;
	double relErr = 1e-6 ;
	double minStepSize ;
	double maxStepSize ;
	int maxNumberOfSteps ;

	public OdeSolver(DerivFunction func, double x0, double y0) {
		this.func = func ;
		this.x0 = x0 ;
		this.y0 = y0 ;
	}

	public void setAbsErr(double absErr) {
		this.absErr = absErr ;
	}

	public void setRelErr(double relErr) {
		this.relErr = relErr ;
	}

	public void setInitialCondition(double x0, double y0) {
		this.x0 = x0 ;
		this.y0 = y0 ;
	}

	public void setX0(double x0) {
		this.x0 = x0 ;
	}

	public void setY0(double y0) {
		this.y0 = y0 ;
	}

	public native double rk2(double x) ;
	public native double[] rk2(double[] x) ;

	public native double rk4(double x) ;
	public native double[] rk4(double[] x) ;

	public native double rkf45(double x) ;
	public native double[] rkf45(double[] x) ;

	public native double rkck(double x) ;
	public native double[] rkck(double[] x) ;

	public native double rk8pd(double x) ;
	public native double[] rk8pd(double[] x) ;

	public native double rk1imp(double x ) ;
	public native double[] rk1imp(double[] x ) ;

	public native double rk2imp(double x) ;
	public native double[] rk2imp(double[] x) ;

	public native double rk4imp(double x) ;
	public native double[] rk4imp(double[] x) ;

	public native double bsimp(double x) ;
	public native double[] bsimp(double[] x) ;

	public native double msadams(double x) ;
	public native double[] msadams(double[] x) ;

	public native double msbdf(double x) ;
	public native double[] msbdf(double[] x) ;

}
