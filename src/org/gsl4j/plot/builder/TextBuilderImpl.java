package org.gsl4j.plot.builder;

//import org.gsl4j.plot.kwargs.TextArgsBuilder;
//import org.gsl4j.plot.kwargs.TextArgsBuilderImpl;


public class TextBuilderImpl implements TextBuilder {

    private CompositeBuilder<TextBuilder> innerBuilder = new CompositeBuilder<>(this);
//    private TextArgsBuilder<TextBuilder> textBuilder = new TextArgsBuilderImpl<>(innerBuilder);

    public TextBuilderImpl(double x, double y, String s) {
        innerBuilder.addToArgs(x);
        innerBuilder.addToArgs(y);
        innerBuilder.addToArgs(s);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "text";
    }
}
