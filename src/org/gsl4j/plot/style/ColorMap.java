package org.gsl4j.plot.style;

public enum ColorMap {

	// Sequential
	viridis("viridis") ,
	plasma("plasma") ,
	inferno("inferno") ,
	magma("magma") ,
	cividis("cividis") ,
	// Cyclic
	twilight("twilight") ,
	twilight_shifted("twilight_shifted") ,
	hsv("hsv") ,
	// Miscellaneous
	flag("flag") ,
	'prism', 'ocean', 'gist_earth', 'terrain', 'gist_stern',
    'gnuplot', 'gnuplot2', 'CMRmap', 'cubehelix', 'brg',
    'gist_rainbow', 'rainbow', 'jet', 'nipy_spectral', 'gist_ncar'






	private String value ;

	private ColorMap(String value) {
		this.value = value ;
	}

	@Override
	public String toString() {
		return value ;
	}

}
