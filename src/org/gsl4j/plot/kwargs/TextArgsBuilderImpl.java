package org.gsl4j.plot.kwargs;

import org.gsl4j.plot.builder.Builder;
import org.gsl4j.plot.builder.CompositeBuilder;

public class TextArgsBuilderImpl<T extends Builder> implements TextArgsBuilder<T> {

//    private final CompositeBuilder<T> innerBuilder;
    final CompositeBuilder<T> innerBuilder;

    public TextArgsBuilderImpl(CompositeBuilder<T> innerBuilder) {
        this.innerBuilder = innerBuilder;
    }

}
