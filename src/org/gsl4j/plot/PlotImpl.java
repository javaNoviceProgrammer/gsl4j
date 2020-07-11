package org.gsl4j.plot;


import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.gsl4j.plot.builder.ArgsBuilderImpl;
import org.gsl4j.plot.builder.Builder;
import org.gsl4j.plot.builder.CLabelBuilder;
import org.gsl4j.plot.builder.CLabelBuilderImpl;
import org.gsl4j.plot.builder.ContourBuilder;
import org.gsl4j.plot.builder.ContourBuilderImpl;
import org.gsl4j.plot.builder.HistBuilder;
import org.gsl4j.plot.builder.HistBuilderImpl;
import org.gsl4j.plot.builder.LabelBuilder;
import org.gsl4j.plot.builder.LabelBuilderImpl;
import org.gsl4j.plot.builder.LegendBuilder;
import org.gsl4j.plot.builder.LegendBuilderImpl;
import org.gsl4j.plot.builder.PColorBuilder;
import org.gsl4j.plot.builder.PColorBuilderImpl;
import org.gsl4j.plot.builder.PlotBuilder;
import org.gsl4j.plot.builder.PlotBuilderImpl;
import org.gsl4j.plot.builder.SaveFigBuilder;
import org.gsl4j.plot.builder.SaveFigBuilderImpl;
import org.gsl4j.plot.builder.ScaleBuilder;
import org.gsl4j.plot.builder.ScaleBuilderImpl;
import org.gsl4j.plot.builder.SubplotBuilder;
import org.gsl4j.plot.builder.SubplotBuilderImpl;
import org.gsl4j.plot.builder.TextBuilder;
import org.gsl4j.plot.builder.TextBuilderImpl;
import org.gsl4j.util.StringUtils;


public class PlotImpl implements Plot {

    List<Builder> registeredBuilders = new LinkedList<>();
    private List<Builder> showBuilders = new LinkedList<>();

    private final boolean dryRun;
    private final PythonConfig pythonConfig;

    PlotImpl(PythonConfig pythonConfig, boolean dryRun) {
        this.pythonConfig = pythonConfig;
        this.dryRun = dryRun;
    }


    PlotImpl(boolean dryRun) {
        this(PythonConfig.systemDefaultPythonConfig(), dryRun);
    }

    @Override
    public LegendBuilder legend() {
        LegendBuilder builder = new LegendBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void figure(String windowTitle) {
        registeredBuilders.add(new ArgsBuilderImpl("figure", windowTitle));
    }

    @Override
    public void title(String title) {
        registeredBuilders.add(new ArgsBuilderImpl("title", title));
    }

    @Override
    public LabelBuilder xlabel(String label) {
        LabelBuilder builder = LabelBuilderImpl.xLabelBuilder(label);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public LabelBuilder ylabel(String label) {
        LabelBuilder builder = LabelBuilderImpl.yLabelBuilder(label);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public ScaleBuilder xscale(ScaleBuilder.Scale scale) {
        ScaleBuilder builder = ScaleBuilderImpl.xScaleBuilder(scale);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public ScaleBuilder yscale(ScaleBuilder.Scale scale) {
        ScaleBuilder builder = ScaleBuilderImpl.yScaleBuilder(scale);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void xlim(Number xmin, Number xmax) {
        registeredBuilders.add(new ArgsBuilderImpl("xlim", xmin, xmax));
    }

    @Override
    public void ylim(Number ymin, Number ymax) {
        registeredBuilders.add(new ArgsBuilderImpl("ylim", ymin, ymax));
    }

    @Override
    public TextBuilder text(double x, double y, String s) {
        TextBuilder builder = new TextBuilderImpl(x, y, s);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public PlotBuilder plot() {
        PlotBuilder builder = new PlotBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public ContourBuilder contour() {
        ContourBuilder builder = new ContourBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public PColorBuilder pcolor() {
        PColorBuilder builder = new PColorBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public HistBuilder hist() {
        HistBuilder builder = new HistBuilderImpl();
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public CLabelBuilder clabel(ContourBuilder contour) {
        CLabelBuilder builder = new CLabelBuilderImpl(contour);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public SaveFigBuilder savefig(String fname) {
        SaveFigBuilder builder = new SaveFigBuilderImpl(fname);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public SubplotBuilder subplot(int nrows, int ncols, int index) {
        SubplotBuilder builder = new SubplotBuilderImpl(nrows, ncols, index);
        registeredBuilders.add(builder);
        return builder;
    }

    @Override
    public void close() {
        registeredBuilders.add(new ArgsBuilderImpl("close"));
    }

    @Override
    public void close(String name) {
        registeredBuilders.add(new ArgsBuilderImpl("close", name));
    }

    @Override
    public void executeSilently() throws IOException, PythonExecutionException {
        List<String> scriptLines = new LinkedList<>();
        scriptLines.add("import numpy as np");
        scriptLines.add("import matplotlib as mpl");
        scriptLines.add("mpl.use('Agg')");
        scriptLines.add("import matplotlib.pyplot as plt");
        registeredBuilders.forEach(b -> scriptLines.add(b.build()));
        showBuilders.forEach(b -> scriptLines.add(b.build()));
        PyCommand command = new PyCommand(pythonConfig);
//        command.execute(Joiner.on('\n').join(scriptLines));
        command.execute(StringUtils.join(scriptLines, '\n'));
    }

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    @Override
    public void show() throws IOException, PythonExecutionException {
        List<String> scriptLines = new LinkedList<>();
        scriptLines.add("import numpy as np");
        if (dryRun) {
            // No need DISPLAY for test run
            scriptLines.add("import matplotlib as mpl");
            scriptLines.add("mpl.use('Agg')");
        }
        scriptLines.add("import matplotlib.pyplot as plt");
        registeredBuilders.forEach(b -> scriptLines.add(b.build()));

        // show
        if (!dryRun) {
            scriptLines.add("plt.show()");
        }

        PyCommand command = new PyCommand(pythonConfig);
//        command.execute(Joiner.on('\n').join(scriptLines));
        command.execute(StringUtils.join(scriptLines, '\n'));

        // After showing, registered plot is cleared
        registeredBuilders.clear();
    }

}
