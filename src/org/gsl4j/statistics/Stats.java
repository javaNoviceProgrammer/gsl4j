package org.gsl4j.statistics;

import org.gsl4j.util.NativeLibraryLoader;

public class Stats {

	static {
		NativeLibraryLoader.loadLibraries();
	}

	private Stats() {

	}

	// Mean, Standard Deviation and Variance

	public static native double mean(double[] data) ;
	public static native double variance(double[] data) ;
	public static native double varianceMean(double[] data, double mean) ;
	public static native double sd(double[] data) ;
	public static native double sdMean(double[] data, double mean) ;
	public static native double totSumSquares(double[] data) ;
	public static native double totSumSquaresMean(double[] data, double mean) ;
	public static native double varianceWithFixedMean(double[] data, double mean) ;
	public static native double sdWithFixedMean(double[] data, double mean) ;

	// Absolute deviation

	public static native double absdev(double[] data) ;
	public static native double absdevMean(double[] data, double mean) ;

	// Higher moments (skewness and kurtosis)

	public static native double skew(double[] data) ;
	public static native double skewMeanSd(double[] data, double mean, double sd) ;
	public static native double kurtosis(double[] data) ;
	public static native double kurtosisMeanSd(double[] data, double mean, double sd) ;

	// Autocorrelation

	public static native double lag1Autocorrelation(double[] data) ;
	public static native double lag1AutocorrelationMean(double[] data, double mean) ;

	// Covariance

	public static native double covariance(double[] data1, double[] data2) ;
	public static native double covarianceMean(double[] data1, double[] data2, double mean1, double mean2) ;

	// Correlation

	public static native double correlation(double[] data1, double[] data2) ;
	public static native double spearman(double[] data1, double[] data2, double[] work) ;

	// Weighted Samples

	public static native double weightedMean(double[] data, double[] weights) ;
	public static native double weightedVariance(double[] data, double[] weights) ;
	public static native double weightedVariance(double[] data, double[] weights, double weightedMean) ;
	public static native double weightedSd(double[] data, double[] weights) ;
	public static native double weightedSdMean(double[] data, double[] weights, double weightedMean) ;




}
