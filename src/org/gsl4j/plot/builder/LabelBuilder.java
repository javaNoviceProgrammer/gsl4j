package org.gsl4j.plot.builder;

import org.gsl4j.plot.kwargs.TextArgsBuilder;

/**
 * matplotlib.pyplot.xlabel(s, *args, **kwargs)
 * <br>
 * matplotlib.pyplot.ylabel(s, *args, **kwargs)
 */
public interface LabelBuilder extends Builder, TextArgsBuilder<LabelBuilder> {


}
