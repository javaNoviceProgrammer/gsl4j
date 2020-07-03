package org.gsl4j.ode;

import org.gsl4j.complex.Complex;
import static org.gsl4j.complex.Complex.* ;

public class OdeSolverComplex {

	DerivnFunction funcSystem ;
	DerivnFunction df_dx ;
	DerivnJacobian df_dy ;
	OdeSystemSolver odeSystemSolver ;
	double x0 ;
	Complex y0 ;

	public OdeSolverComplex(DerivFunctionComplex func, DerivFunctionComplex dfdx, DerivFunctionComplex dfdy, double x0, Complex y0) {
		this.x0 = x0 ;
		this.y0 = y0 ;
		// z[0] = realpart, z[1] = imaginary part
		this.funcSystem = (x, z) -> {
			Complex val = func.value(x, z[0]+j*z[1]) ;
			return new double[]{val.re(), val.im()} ;
		} ;
		this.odeSystemSolver = new OdeSystemSolver(2, funcSystem, x0, y0.re(), y0.im()) ;
	}

	/*------------- rk2 -------------*/

	public double[] rk2(double x) {
		return odeSystemSolver.rk2(x) ;
	}

	public double[][] rk2(double[] x) {
		return odeSystemSolver.rk2(x) ;
	}

	public Complex rk2Complex(double x) {
		double[] z = odeSystemSolver.rk2(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rk4 -------------*/

	public double[] rk4(double x) {
		return odeSystemSolver.rk4(x) ;
	}

	public double[][] rk4(double[] x) {
		return odeSystemSolver.rk4(x) ;
	}

	public Complex rk4Complex(double x) {
		double[] z = odeSystemSolver.rk4(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rkf45 -------------*/

	public double[] rkf45(double x) {
		return odeSystemSolver.rkf45(x) ;
	}

	public double[][] rkf45(double[] x) {
		return odeSystemSolver.rk4(x) ;
	}

	public Complex rkf45Complex(double x) {
		double[] z = odeSystemSolver.rkf45(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rkck -------------*/

	public double[] rkck(double x) {
		return odeSystemSolver.rkck(x) ;
	}

	public double[][] rkck(double[] x) {
		return odeSystemSolver.rkck(x) ;
	}

	public Complex rkckComplex(double x) {
		double[] z = odeSystemSolver.rkck(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rk8pd -------------*/

	public double[] rk8pd(double x) {
		return odeSystemSolver.rk8pd(x) ;
	}

	public double[][] rk8pd(double[] x) {
		return odeSystemSolver.rk8pd(x) ;
	}

	public Complex rk8pdComplex(double x) {
		double[] z = odeSystemSolver.rk8pd(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rk1imp -------------*/

	public double[] rk1imp(double x ) {
		return odeSystemSolver.rk1imp(x) ;
	}

	public double[][] rk1imp(double[] x ) {
		return odeSystemSolver.rk1imp(x) ;
	}

	public Complex rk1impComplex(double x) {
		double[] z = odeSystemSolver.rk1imp(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rk2imp -------------*/

	public double[] rk2imp(double x) {
		return odeSystemSolver.rk2imp(x) ;
	}

	public double[][] rk2imp(double[] x) {
		return odeSystemSolver.rk2imp(x) ;
	}

	public Complex rk2impComplex(double x) {
		double[] z = odeSystemSolver.rk2imp(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- rk4imp -------------*/

	public double[] rk4imp(double x) {
		return odeSystemSolver.rk4imp(x) ;
	}

	public double[][] rk4imp(double[] x) {
		return odeSystemSolver.rk4imp(x) ;
	}

	public Complex rk4impComplex(double x) {
		double[] z = odeSystemSolver.rk4imp(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- bsimp -------------*/

	public double[] bsimp(double x) {
		return odeSystemSolver.bsimp(x) ;
	}

	public double[][] bsimp(double[] x) {
		return odeSystemSolver.bsimp(x) ;
	}

	public Complex bsimpComplex(double x) {
		double[] z = odeSystemSolver.bsimp(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- msadams -------------*/

	public double[] msadams(double x) {
		return odeSystemSolver.msadams(x) ;
	}

	public double[][] msadams(double[] x) {
		return odeSystemSolver.msadams(x) ;
	}

	public Complex msadamsComplex(double x) {
		double[] z = odeSystemSolver.msadams(x) ;
		return ofRect(z[0], z[1]) ;
	}

	/*------------- msbdf -------------*/

	public double[] msbdf(double x) {
		return odeSystemSolver.msbdf(x) ;
	}

	public double[][] msbdf(double[] x) {
		return odeSystemSolver.msbdf(x) ;
	}

	public Complex msbdfComplex(double x) {
		double[] z = odeSystemSolver.msbdf(x) ;
		return ofRect(z[0], z[1]) ;
	}

}
