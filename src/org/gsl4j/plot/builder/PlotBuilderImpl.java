package org.gsl4j.plot.builder;


import java.util.List;

import org.gsl4j.plot.kwargs.Line2DBuilder;
import org.gsl4j.plot.kwargs.Line2DBuilderImpl;


public class PlotBuilderImpl implements PlotBuilder {

    private CompositeBuilder<PlotBuilder> innerBuilder = new CompositeBuilder<>(this);
    private Line2DBuilder<PlotBuilder> line2DBuilder = new Line2DBuilderImpl<>(innerBuilder);

    @Override
    public PlotBuilder add(List<? extends Number> x) {
        return innerBuilder.addToArgs(x);
    }

    @Override
    public PlotBuilder add(List<? extends Number> x, List<? extends Number> y) {
        innerBuilder.addToArgs(x);
        return innerBuilder.addToArgs(y);
    }

    @Override
    public PlotBuilder add(List<? extends Number> x, List<? extends Number> y, String fmt) {
        innerBuilder.addToArgs(x);
        innerBuilder.addToArgs(y);
        return innerBuilder.addToArgs(fmt);
    }

    @Override
    public PlotBuilder linestyle(String arg) {
        return line2DBuilder.linestyle(arg);
    }

    @Override
    public PlotBuilder ls(String arg) {
        return line2DBuilder.ls(arg);
    }

    @Override
    public PlotBuilder linewidth(String arg) {
        return line2DBuilder.linewidth(arg);
    }

    @Override
    public PlotBuilder lw(String arg) {
        return line2DBuilder.lw(arg);
    }

    @Override
    public PlotBuilder label(String arg) {
        return line2DBuilder.label(arg);
    }

    @Override
    public PlotBuilder color(String arg) {
        return line2DBuilder.color(arg);
    }

    @Override
    public String build() {
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "plot";
    }
}
