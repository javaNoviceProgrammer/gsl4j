package org.gsl4j.plot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.gsl4j.util.MathUtils;


public class NumpyUtils {

    // TODO: more options from numpy
    public static List<Double> linspace(double start, double end, int num) {
    		double[] vals = MathUtils.linspace(start, end, num) ;
    		List<Double> result = new ArrayList<>() ;
    		for(int i=0; i<vals.length; i++)
    			result.add(vals[i]) ;
    		return result ;
    }

    public static List<Double> arange(double start, double end, double step) {
		double[] vals = MathUtils.linspace(start, end, step) ;
		List<Double> result = new ArrayList<>() ;
		for(int i=0; i<vals.length; i++)
			result.add(vals[i]) ;
		return result ;
    }

    public static <T extends Number> Grid<T> meshgrid(List<T> x, List<T> y) {
        Grid<T> grid = new Grid<>();
        grid.x = IntStream.range(0, y.size()).mapToObj(i -> x).collect(Collectors.toList());
        grid.y = y.stream().map(t -> (IntStream.range(0, x.size()).mapToObj(i -> t).collect(Collectors.toList()))).collect(Collectors.toList());
        return grid;
    }

    public static class Grid<T extends Number> {
        public List<List<T>> x;
        public List<List<T>> y;

        public <R> List<List<R>> calcZ(BiFunction<T, T, R> biFunction) {
            return IntStream.range(0, x.size()).mapToObj(i ->
                IntStream.range(0, x.get(i).size()).mapToObj(j ->
                    biFunction.apply(x.get(i).get(j), y.get(i).get(j))
                ).collect(Collectors.toList())
            ).collect(Collectors.toList());
        }
    }

}
