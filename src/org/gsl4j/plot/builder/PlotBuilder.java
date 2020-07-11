package org.gsl4j.plot.builder;


import java.util.List;

import org.gsl4j.plot.kwargs.Line2DBuilder;


/**
 * matplotlib.pyplot.plot(*args, **kwargs)
 */
public interface PlotBuilder extends Builder, Line2DBuilder<PlotBuilder> {

    PlotBuilder add(List<? extends Number> nums);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y);

    PlotBuilder add(List<? extends Number> x, List<? extends Number> y, String fmt);
}
