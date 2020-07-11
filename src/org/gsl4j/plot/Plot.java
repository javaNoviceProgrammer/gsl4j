package org.gsl4j.plot;

import java.io.IOException;

import org.gsl4j.plot.builder.CLabelBuilder;
import org.gsl4j.plot.builder.ContourBuilder;
import org.gsl4j.plot.builder.HistBuilder;
import org.gsl4j.plot.builder.LabelBuilder;
import org.gsl4j.plot.builder.LegendBuilder;
import org.gsl4j.plot.builder.PColorBuilder;
import org.gsl4j.plot.builder.PlotBuilder;
import org.gsl4j.plot.builder.SaveFigBuilder;
import org.gsl4j.plot.builder.ScaleBuilder;
import org.gsl4j.plot.builder.SubplotBuilder;
import org.gsl4j.plot.builder.TextBuilder;


public interface Plot {

    static Plot create() {
        return new PlotImpl(PythonConfig.systemDefaultPythonConfig(), false);
    }

    static Plot create(PythonConfig pythonConfig) {
        return new PlotImpl(pythonConfig, false);
    }

    LegendBuilder legend();

    /**
     * This renews a figure. Make sure that this has to be put before adding plots.
     * Unless that, a new figure window will be open.
     */
    void figure(String windowTitle);

    void title(String title);

    LabelBuilder xlabel(String label);

    LabelBuilder ylabel(String label);

    ScaleBuilder xscale(ScaleBuilder.Scale scale);

    ScaleBuilder yscale(ScaleBuilder.Scale scale);

    void xlim(Number xmin, Number xmax);

    void ylim(Number ymin, Number ymax);

    TextBuilder text(double x, double y, String s);

    PlotBuilder plot();

    ContourBuilder contour();

    PColorBuilder pcolor();

    HistBuilder hist();

    CLabelBuilder clabel(ContourBuilder contour);

    SaveFigBuilder savefig(String fname);

    SubplotBuilder subplot(int nrows, int ncols, int index);

    /**
     * Close a figure window.
     */
    void close();

    /**
     * Close a figure window with name label.
     */
    void close(String name);

    /**
     * Silently execute Python script until here by builders.
     * It is mostly useful to execute `plt.savefig()` without showing by window.
     */
    void executeSilently() throws IOException, PythonExecutionException;

    /**
     * matplotlib.pyplot.show(*args, **kw)
     */
    void show() throws IOException, PythonExecutionException;

}
