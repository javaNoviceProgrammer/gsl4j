package org.gsl4j.plot.kwargs;

import org.gsl4j.plot.builder.Builder;

public interface Line2DBuilder<T extends Builder> extends KwargsBuilder {

    T linestyle(String arg);

    T ls(String arg);

    T linewidth(String arg);

    T lw(String arg);

    T label(String arg);

    T color(String arg);
}
