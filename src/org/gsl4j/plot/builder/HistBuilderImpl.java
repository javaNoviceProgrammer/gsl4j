package org.gsl4j.plot.builder;


import java.util.LinkedList;
import java.util.List;

import org.gsl4j.plot.kwargs.PatchBuilder;
import org.gsl4j.plot.kwargs.PatchBuilderImpl;
import org.gsl4j.util.StringUtils;


public class HistBuilderImpl implements HistBuilder {

    private CompositeBuilder<HistBuilder> innerBuilder = new CompositeBuilder<>(this);
    private PatchBuilder<HistBuilder> patchBuilder = new PatchBuilderImpl<>(innerBuilder);
    private List<List<? extends Number>> xList = new LinkedList<>();

    @Override
    public HistBuilder add(List<? extends Number> nums) {
        xList.add(nums);
        return this;
    }

    @Override
    public HistBuilder bins(int arg) {
        return innerBuilder.addToKwargs("bins", arg);
    }

    @Override
    public HistBuilder bins(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("bins", nums);
    }

    @Override
    public HistBuilder range(double lower, double upper) {
        return innerBuilder.addToKwargsWithoutQuoting("range", String.format("(%f, %f)", lower, upper));
    }

    @Override
    public HistBuilder density(boolean arg) {
        return innerBuilder.addToKwargs("density", arg);
    }

    @Override
    public HistBuilder weights(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("weights", nums);
    }

    @Override
    public HistBuilder cumulative(boolean arg) {
        return innerBuilder.addToKwargs("cumulative", arg);
    }

    @Override
    public HistBuilder bottom(double arg) {
        return innerBuilder.addToKwargs("bottom", arg);
    }

    @Override
    public HistBuilder bottom(List<? extends Number> nums) {
        return innerBuilder.addToKwargs("bottom", nums);
    }

    @Override
    public HistBuilder histtype(HistType histType) {
        return innerBuilder.addToKwargs("histtype", histType.toString());
    }

    @Override
    public HistBuilder align(Align align) {
        return innerBuilder.addToKwargs("align", align.name());
    }

    @Override
    public HistBuilder orientation(Orientation orientation) {
        return innerBuilder.addToKwargs("orientation", orientation.name());
    }

    @Override
    public HistBuilder rwidth(double arg) {
        return innerBuilder.addToKwargs("rwidth", arg);
    }

    @Override
    public HistBuilder log(boolean arg) {
        return innerBuilder.addToKwargs("log", arg);
    }

    @Override
    public HistBuilder color(String... args) {
    		if(args.length==0)
    			throw new IllegalArgumentException(".color() needs to have at least one argument.") ;
//        return innerBuilder.addToKwargsWithoutQuoting("color", "[\"" + Joiner.on("\", \"").join(args) + "\"]");
        return innerBuilder.addToKwargsWithoutQuoting("color", "[\"" + StringUtils.join(args, "\", \"") + "\"]");
    }

    @Override
    public HistBuilder stacked(boolean arg) {
        return innerBuilder.addToKwargs("stacked", arg);
    }

    @Override
    public HistBuilder linestyle(String arg) {
        return patchBuilder.linestyle(arg);
    }

    @Override
    public HistBuilder ls(String arg) {
        return patchBuilder.ls(arg);
    }

    @Override
    public HistBuilder linewidth(String arg) {
        return patchBuilder.linewidth(arg);
    }

    @Override
    public HistBuilder lw(String arg) {
        return patchBuilder.lw(arg);
    }

    @Override
    public HistBuilder label(String arg) {
        return patchBuilder.label(arg);
    }

    @Override
    public String build() {
		if(xList.size()==0)
			throw new IllegalArgumentException(".add() is needed to be called at least once.") ;
        innerBuilder.addToArgsWithoutQuoting(xList.toString());
        return innerBuilder.build();
    }

    @Override
    public String getMethodName() {
        return "hist";
    }

}
