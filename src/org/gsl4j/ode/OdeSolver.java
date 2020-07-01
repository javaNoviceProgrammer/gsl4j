package org.gsl4j.ode;

import org.gsl4j.diff.NumericalDiff;
import org.gsl4j.util.NativeLibraryLoader;

public class OdeSolver {

	static {
		NativeLibraryLoader.loadLibraries();
		initIDs() ;
	}

	private static native void initIDs() ;

	DerivFunction func ; // f(x,y)
	DerivFunction df_dy  ; // df/dy
	DerivFunction df_dx ; // df/dx
	double x0 ;
	double y0 ;
	double absErr = 1e-6 ;
	double relErr = 1e-10 ;
	double minStepSize = 1e-6 ;
	double maxStepSize = 0.1 ;
	int maxNumberOfSteps ;

	public OdeSolver(DerivFunction func, DerivFunction dfdx, DerivFunction dfdy, double x0, double y0) {
		this.func = func ;
		this.df_dx = dfdx ;
		this.df_dy = dfdy ;
		this.x0 = x0 ;
		this.y0 = y0 ;
	}

	public OdeSolver(DerivFunction func, double x0, double y0) {
		this.func = func ;
		this.df_dx = (x,y) -> NumericalDiff.central(t -> func.value(t, y), x, 1e-3) ;
		this.df_dy = (x,y) -> NumericalDiff.central(t -> func.value(x, t), y, 1e-3) ;
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

	public void setMinStepSize(double minStepSize) {
		this.minStepSize = minStepSize ;
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
