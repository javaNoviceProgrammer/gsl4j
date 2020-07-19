package org.gsl4j.plot.contour;

public class ContourLabel {

	double[] levels ;
	double fontsize = 10.0 ;
	String color ;
	boolean inline = true ;
	double inlineSpacing = 5.0 ;
	String fmt ; // label formatter
	boolean manual = false ;
	boolean rightsideUp = true ;
	boolean useClabelText = false ;


	String getPythonCode() {
		StringBuilder sb = new StringBuilder() ;

		return sb.toString() ;
	}


	@Override
	public String toString() {
		return getPythonCode() ;
	}


}
