package org.gsl4j.plot;

import java.util.Arrays;

public class XYSeries {

	double[] x ;
	double[] y ;
	String xvar ;
	String yvar ;
	String label ;
	String color ;
	String marker ;
	String linestyle ;
	int linewidth = 2 ;
	int markerSize = 0 ;
	boolean semilogx = false ;
	boolean semilogy = false ;
	boolean loglog = false ;
	// additional Line2D params
	String drawStyle ;
	String fillStyle ;
	boolean inLayout ;
	int markEvery = 1 ;
	boolean rasterized ;
	boolean snap ;
	String solidCapStyle ;
	String solidJoinStyle ;
	boolean visible = true ;

	String markerEdgeColor ;
	int markerEdgeWidth ;
	String markerFaceColor ;

	public XYSeries(double[] x, double[] y, String xvar, String yvar, String color, String marker, int markerSize, String linestyle, int linewidth, String label) {
		this.x = x ;
		this.y = y ;
		this.xvar = (xvar!=null)? xvar.trim() : null ;
		this.yvar = (yvar!=null)? yvar.trim() : null ;
		this.color = (color!=null)? color.trim() : null ;
		this.label = (label!=null)? label.trim() : null ;
		this.marker = (marker!=null)? marker.trim() : null ;
		this.markerSize = markerSize ;
		this.linestyle = (linestyle!=null)? linestyle.trim() : null ;
		this.linewidth = linewidth ;
	}

	public XYSeries setXData(double[] x) {
		this.x = x ;
		return this ;
	}

	public XYSeries setYData(double[] y) {
		this.y = y ;
		return this ;
	}

	public XYSeries setXvar(String xvar) {
		this.xvar = (xvar!=null) ? xvar.trim() : null ;
		return this ;
	}

	public XYSeries setYvar(String yvar) {
		this.yvar = (yvar!=null) ? yvar.trim() : null ;
		return this ;
	}

	public XYSeries color(String color) {
		this.color = (color!=null) ? color.trim() : null ;
		return this ;
	}

	public XYSeries marker(String marker) {
		this.marker = (marker!=null) ? marker.trim() : null ;
		return this ;
	}

	public XYSeries marker(Marker marker) {
		this.marker = (marker!=null) ? marker.toString().trim() : null ;
		return this ;
	}

	public XYSeries markerSize(int markerSize) {
		this.markerSize = markerSize ;
		return this ;
	}

	public XYSeries markerEdgeColor(String markerEdgeColor) {
		this.markerEdgeColor = (markerEdgeColor!=null) ? markerEdgeColor.trim() : null ;
		return this ;
	}

	public XYSeries markerEdgeWidth(int markerEdgeWidth) {
		this.markerEdgeWidth = markerEdgeWidth ;
		return this ;
	}

	public XYSeries linestyle(String linestyle) {
		this.linestyle = (linestyle!=null) ? linestyle.trim() : null ;
		return this ;
	}

	public XYSeries linestyle(LineStyle linestyle) {
		this.linestyle = (linestyle!=null) ? linestyle.toString().trim() : null ;
		return this ;
	}

	public XYSeries linewidth(int linewidth) {
		this.linewidth = linewidth ;
		return this ;
	}

	public XYSeries label(String label) {
		this.label = (label!=null) ? label.trim() : null ;
		return this ;
	}

	public XYSeries fillstyle(String fillStyle) {
		this.fillStyle = (fillStyle!=null) ? fillStyle.trim() : null ;
		return this ;
	}

	public XYSeries fillstyle(FillStyle fillStyle) {
		this.fillStyle = (fillStyle!=null) ? fillStyle.toString().trim() : null ;
		return this ;
	}

	public XYSeries semilogx() {
		semilogx = true ;
		semilogy = false ;
		loglog = false ;
		return this ;
	}

	public XYSeries semilogy() {
		semilogx = false ;
		semilogy = true ;
		loglog = false ;
		return this ;
	}

	public XYSeries loglog() {
		semilogx = false ;
		semilogy = false ;
		loglog = true ;
		return this ;
	}

	String getPythonCode() {
		StringBuilder sb = new StringBuilder() ;
		if(semilogx)
			sb.append("plt.semilogx(") ;
		else if(semilogy)
			sb.append("plt.semilogy(") ;
		else if(loglog)
			sb.append("plt.loglog(") ;
		else
			sb.append("plt.plot(") ;
		if(xvar == null)
			throw new IllegalArgumentException("x variable cannot be NULL") ;
		else
			sb.append(xvar+", ") ;
		if(yvar == null)
			throw new IllegalArgumentException("x variable cannot be NULL") ;
		else
			sb.append(yvar) ;
		if(color != null) {
			sb.append(", ") ;
			sb.append("color='" + color + "'") ;
		}
		if(marker != null) {
			sb.append(", ") ;
			sb.append("marker='" + marker + "'") ;
		}
		if(markerSize > 0) {
			sb.append(", ") ;
			sb.append("markersize=" + markerSize) ;
		}
		if(markerEdgeColor != null) {
			sb.append(", ") ;
			sb.append("markeredgecolor='" + markerEdgeColor + "'") ;
		}
		if(markerEdgeWidth >= 0) {
			sb.append(", ") ;
			sb.append("markeredgewidth=" + markerEdgeWidth) ;
		}
		if(linestyle != null) {
			sb.append(", ") ;
			sb.append("linestyle='" + linestyle + "'") ;
		}
		if(linewidth >= 0) {
			sb.append(", ") ;
			sb.append("linewidth=" + linewidth) ;
		}
		if(label != null) {
			sb.append(", ") ;
			sb.append("label='" + label + "'") ;
		}
		if(fillStyle != null) {
			sb.append(", ") ;
			sb.append("fillstyle='" + fillStyle + "'") ;
		}
		sb.append(")") ;
		return sb.toString() ;
	}

	@Override
	public String toString() {
		return getPythonCode() ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + linewidth;
		result = prime * result + ((marker == null) ? 0 : marker.hashCode());
		result = prime * result + Arrays.hashCode(x);
		result = prime * result + ((xvar == null) ? 0 : xvar.hashCode());
		result = prime * result + Arrays.hashCode(y);
		result = prime * result + ((yvar == null) ? 0 : yvar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XYSeries other = (XYSeries) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (linewidth != other.linewidth)
			return false;
		if (marker == null) {
			if (other.marker != null)
				return false;
		} else if (!marker.equals(other.marker))
			return false;
		if (xvar == null) {
			if (other.xvar != null)
				return false;
		} else if (!xvar.equals(other.xvar))
			return false;
		if (yvar == null) {
			if (other.yvar != null)
				return false;
		} else if (!yvar.equals(other.yvar))
			return false;
		return true;
	}

}
