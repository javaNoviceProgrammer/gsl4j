package org.gsl4j.roots;

import java.util.ArrayList;
import java.util.List;

import org.gsl4j.diff.NumericalDiff;
import org.gsl4j.function.MathFunction;
import org.gsl4j.util.NativeLibraryLoader;

/**
 * This class describes routines for finding roots of arbitrary one-dimensional functions. The library provides low level components for a variety of iterative solvers and convergence tests. These can be combined by the user to achieve the desired solution, with full access to the intermediate steps of the iteration. Each class of methods uses the same framework, so that you can switch between solvers at runtime without needing to recompile your program. Each instance of a solver keeps track of its own state, allowing the solvers to be used in multi-threaded programs.
 * <br>
 * The header file {@code gsl_roots.h} contains prototypes for the root finding functions and related declarations.
 *
 * @author Meisam
 *
 */
public class RealRoot {

	static {
		NativeLibraryLoader.loadLibraries();
		initFieldIDs() ;
	}

	private static native void initFieldIDs() ;

	double absErr = 1e-10 ;
	double relErr = 1e-10 ;
	int maxNumberOfIterations = 100 ;
	RealRootFunction func ;
	RealRootDerivFunction derivFunc ;

	/**
	 * One-dimensional root finding algorithms can be divided into two classes, root bracketing and root polishing. Algorithms which proceed by bracketing a root are guaranteed to converge. Bracketing algorithms begin with a bounded region known to contain a root. The size of this bounded region is reduced, iteratively, until it encloses the root to a desired tolerance. This provides a rigorous error estimate for the location of the root.
	 * <br><br>
	 * The technique of root polishing attempts to improve an initial guess to the root. These algorithms converge only if started “close enough” to a root, and sacrifice a rigorous error bound for speed. By approximating the behavior of a function in the vicinity of a root they attempt to find a higher order improvement of an initial guess. When the behavior of the function is compatible with the algorithm and a good initial guess is available a polishing algorithm can provide rapid convergence.
	 */
	public RealRoot() {

	}

	/**
	 *
	 * One-dimensional root finding algorithms can be divided into two classes, root bracketing and root polishing. Algorithms which proceed by bracketing a root are guaranteed to converge. Bracketing algorithms begin with a bounded region known to contain a root. The size of this bounded region is reduced, iteratively, until it encloses the root to a desired tolerance. This provides a rigorous error estimate for the location of the root.
	 * <br><br>
	 * The technique of root polishing attempts to improve an initial guess to the root. These algorithms converge only if started “close enough” to a root, and sacrifice a rigorous error bound for speed. By approximating the behavior of a function in the vicinity of a root they attempt to find a higher order improvement of an initial guess. When the behavior of the function is compatible with the algorithm and a good initial guess is available a polishing algorithm can provide rapid convergence.
	 *
	 * @param func : RealRootFunction to be used
	 */
	public RealRoot(RealRootFunction func) {
		this.func = func ;
		this.derivFunc = t -> new double[] {func.value(t), NumericalDiff.central(func, t, 0.1)} ;
	}

	/**
	 *
	 * One-dimensional root finding algorithms can be divided into two classes, root bracketing and root polishing. Algorithms which proceed by bracketing a root are guaranteed to converge. Bracketing algorithms begin with a bounded region known to contain a root. The size of this bounded region is reduced, iteratively, until it encloses the root to a desired tolerance. This provides a rigorous error estimate for the location of the root.
	 * <br><br>
	 * The technique of root polishing attempts to improve an initial guess to the root. These algorithms converge only if started “close enough” to a root, and sacrifice a rigorous error bound for speed. By approximating the behavior of a function in the vicinity of a root they attempt to find a higher order improvement of an initial guess. When the behavior of the function is compatible with the algorithm and a good initial guess is available a polishing algorithm can provide rapid convergence.
	 *
	 * @param func : MathFunction to be used
	 */
	public RealRoot(MathFunction func) {
		this.func = t -> func.value(t) ;
		this.derivFunc = t -> new double[] {func.value(t), NumericalDiff.central(func, t, 0.1)} ; ;
	}

	/**
	 *
	 * One-dimensional root finding algorithms can be divided into two classes, root bracketing and root polishing. Algorithms which proceed by bracketing a root are guaranteed to converge. Bracketing algorithms begin with a bounded region known to contain a root. The size of this bounded region is reduced, iteratively, until it encloses the root to a desired tolerance. This provides a rigorous error estimate for the location of the root.
	 * <br><br>
	 * The technique of root polishing attempts to improve an initial guess to the root. These algorithms converge only if started “close enough” to a root, and sacrifice a rigorous error bound for speed. By approximating the behavior of a function in the vicinity of a root they attempt to find a higher order improvement of an initial guess. When the behavior of the function is compatible with the algorithm and a good initial guess is available a polishing algorithm can provide rapid convergence.
	 *
	 * @param func : RealRootDerivFunction to be used
	 */
	public RealRoot(RealRootDerivFunction func) {
		this.func = t -> func.value(t)[0] ;
		this.derivFunc = func ;
	}

	public void setFunction(RealRootFunction func) {
		this.func = func ;
		this.derivFunc = t -> new double[] {func.value(t), NumericalDiff.central(func, t, 0.1)} ; ;
	}

	public void setDerivFunction(RealRootDerivFunction derivfunc) {
		this.func = t -> derivfunc.value(t)[0] ;
		this.derivFunc = derivfunc ;
	}

	// Root Bracketing Algorithms (use func)
	public native double bisection(double start, double end) ;
	public native double falsepos(double start, double end) ;
	public native double brent(double start, double end) ;

	public double bisectionSafe(double start, double end) {
		if(Math.abs(func.value(start))<absErr)
			return start ;
		else if(Math.abs(func.value(end))<absErr)
			return end ;
		else if(func.value(start)>0.0 && func.value(end)>0.0)
			return Double.NaN ;
		else if(func.value(start)<0.0 && func.value(end)<0.0)
			return Double.NaN ;
		else
			return bisection(start, end) ;
	}

	public double falseposSafe(double start, double end) {
		if(Math.abs(func.value(start))<absErr)
			return start ;
		else if(Math.abs(func.value(end))<absErr)
			return end ;
		else if(func.value(start)>0.0 && func.value(end)>0.0)
			return Double.NaN ;
		else if(func.value(start)<0.0 && func.value(end)<0.0)
			return Double.NaN ;
		else
			return falsepos(start, end) ;
	}

	public double brentSafe(double start, double end) {
		if(Math.abs(func.value(start))<absErr)
			return start ;
		else if(Math.abs(func.value(end))<absErr)
			return end ;
		else if(func.value(start)>0.0 && func.value(end)>0.0)
			return Double.NaN ;
		else if(func.value(start)<0.0 && func.value(end)<0.0)
			return Double.NaN ;
		else
			return brent(start, end) ;
	}

	public List<Double> bisection(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = bisectionSafe(points[i], points[i+1]) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}

	public List<Double> falsepos(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = falseposSafe(points[i], points[i+1]) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}

	public List<Double> brent(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = brentSafe(points[i], points[i+1]) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}

	// Root Finding Algorithms using Derivatives (use derivFunc)
	public native double newton(double estimate) ;
	public native double secant(double estimate) ;
	public native double steffenson(double estimate) ;

	public double newtonSafe(double estimate) {
		if(Math.abs(func.value(estimate))<absErr)
			return estimate ;
		else {
			double root = newton(estimate) ;
			if(Math.abs(func.value(root))<absErr)
				return root ;
			else
				return Double.NaN ;
		}
	}

	public double secantSafe(double estimate) {
		if(Math.abs(func.value(estimate))<absErr)
			return estimate ;
		else {
			double root = secant(estimate) ;
			if(Math.abs(func.value(root))<absErr)
				return root ;
			else
				return Double.NaN ;
		}
	}

	public double steffensonSafe(double estimate) {
		if(Math.abs(func.value(estimate))<absErr)
			return estimate ;
		else {
			double root = steffenson(estimate) ;
			if(Math.abs(func.value(root))<absErr)
				return root ;
			else
				return Double.NaN ;
		}
	}

	public List<Double> newton(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = newtonSafe(0.5*(points[i]+points[i+1])) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}

	public List<Double> secant(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = secantSafe(0.5*(points[i]+points[i+1])) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}

	public List<Double> steffenson(double start, double end, int subIntervals) {
		List<Double> roots = new ArrayList<>() ;
		double[] points = new double[subIntervals+1] ;
		double dx = (end-start)/subIntervals ;
		for(int i=0; i<points.length; i++) {
			points[i] = start + i*dx ;
		}
		for(int i=0; i<subIntervals; i++) {
			double potentialRoot = steffensonSafe(0.5*(points[i]+points[i+1])) ;
			if(!Double.isNaN(potentialRoot)){
				boolean repeated = false ;
				for(int j=0;j<roots.size(); j++){
					if(Math.abs(potentialRoot-roots.get(j))<absErr)
						repeated = true ;
				}
				if(!repeated)
					roots.add(potentialRoot) ;
			}
		}
		return roots ;
	}


}
