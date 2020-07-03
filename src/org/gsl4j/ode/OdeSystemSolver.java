package org.gsl4j.ode;

import org.gsl4j.diff.NumericalDiff;
import org.gsl4j.util.NativeLibraryLoader;

public class OdeSystemSolver {

	static {
		NativeLibraryLoader.loadLibraries();
		initIDs() ;
	}

	private static native void initIDs() ;

	DerivnFunction func ; // f(x,y1,y2,...,yn) = [f1,f2,...,fn]
	DerivnFunction df_dx ; // df/dx [df1_dx, df2_dx, ..., dfn_dx]
	DerivnJacobian df_dy  ; // J_ij = df_i/dy_j

	int dim ;
	double x0 ;
	double[] y0 ;
	double absErr = 1e-6 ;
	double relErr = 1e-10 ;
	double minStepSize = 1e-6 ;
	double maxStepSize = 0.1 ;
	int maxNumberOfSteps = 1000 ;

	public OdeSystemSolver(int dim, DerivnFunction func, DerivnFunction dfdx, DerivnJacobian dfdy, double x0, double... y0) {
		this.dim = dim ;
		this.func = func ;
		this.df_dx = dfdx ;
		this.df_dy = dfdy ;
		this.x0 = x0 ;
		this.y0 = y0 ;

		if(y0.length != dim)
			throw new IllegalStateException("Dimension does not match initial conditions") ;
	}

	public OdeSystemSolver(int dim, DerivnFunction func, DerivnJacobian dfdy, double x0, double... y0) {
		this.dim = dim ;
		this.func = func ;
		this.df_dx = getdFdx(dim, func) ;
		this.df_dy = dfdy ;
		this.x0 = x0 ;
		this.y0 = y0 ;

		if(y0.length != dim)
			throw new IllegalStateException("Dimension does not match initial conditions") ;
	}

	public OdeSystemSolver(int dim, DerivnFunction func, double x0, double... y0) {
		this.dim = dim ;
		this.func = func ;
		this.df_dx = getdFdx(dim, func) ;
		this.df_dy = getdFdy(dim, func) ;
		this.x0 = x0 ;
		this.y0 = y0 ;

		if(y0.length != dim)
			throw new IllegalStateException("Dimension does not match initial conditions") ;
	}

	private DerivnFunction getdFdx(int dim, DerivnFunction func) {
		return (x,y) -> {
			double[] dfdx = new double[dim] ;
			for(int i=0; i<dim; i++) {
				int k = i ;
				dfdx[i] = NumericalDiff.central(t -> func.values(t, y)[k], x, 1e-3) ;
			}
			return dfdx ;
		};
	}

	private DerivnJacobian getdFdy(int dim, DerivnFunction func) {
		return (x,y) -> {
			double[][] dfdy = new double[dim][dim] ;
			for(int i=0; i<dim; i++) {
				for(int j=0; j<dim; j++) {
					int row = i ;
					int col = j ;
					dfdy[i][j] = NumericalDiff.central(t -> func.values(x, t)[row], y[col], 1e-3) ;
				}
			}
			return dfdy ;
		};
	}

	public void setAbsErr(double absErr) {
		this.absErr = absErr ;
	}

	public void setRelErr(double relErr) {
		this.relErr = relErr ;
	}

	public void setInitialCondition(double x0, double[] y0) {
		this.x0 = x0 ;
		this.y0 = y0 ;
	}

	public void setX0(double x0) {
		this.x0 = x0 ;
	}

	public void setY0(double[] y0) {
		this.y0 = y0 ;
	}

	public void setMinStepSize(double minStepSize) {
		this.minStepSize = minStepSize ;
	}

	public native double[] rk2(double x) ;
	public native double[][] rk2(double[] x) ;

	public native double[] rk4(double x) ;
	public native double[][] rk4(double[] x) ;

	public native double[] rkf45(double x) ;
	public native double[][] rkf45(double[] x) ;

	public native double[] rkck(double x) ;
	public native double[][] rkck(double[] x) ;

	public native double[] rk8pd(double x) ;
	public native double[][] rk8pd(double[] x) ;

	public native double[] rk1imp(double x ) ;
	public native double[][] rk1imp(double[] x ) ;

	public native double[] rk2imp(double x) ;
	public native double[][] rk2imp(double[] x) ;

	public native double[] rk4imp(double x) ;
	public native double[][] rk4imp(double[] x) ;

	public native double[] bsimp(double x) ;
	public native double[][] bsimp(double[] x) ;

	public native double[] msadams(double x) ;
	public native double[][] msadams(double[] x) ;

	public native double[] msbdf(double x) ;
	public native double[][] msbdf(double[] x) ;

}
