package org.gsl4j.plot.builder;

import org.gsl4j.plot.kwargs.TextArgsBuilder;

/**
 * matplotlib.pyplot.xscale(scale, **kwargs)
 * matplotlib.pyplot.yscale(scale, **kwargs)
 */
public interface ScaleBuilder extends Builder, TextArgsBuilder<ScaleBuilder> {

    enum Scale {
        linear,
        log,
        logit,
        symlog;
    }

}
