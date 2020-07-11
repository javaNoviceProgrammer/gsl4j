package org.gsl4j.plot.builder;


/**
 * matplotlib.pyplot.legend(*args, **kwargs)
 */
public interface LegendBuilder extends Builder {

    LegendBuilder loc(int arg);

    LegendBuilder loc(String arg);

    LegendBuilder loc(double x, double y);

}
