package com.interaxon.muse.museioreceiver;

import java.io.Serializable;

public class FeatureVector implements Serializable {
	
	private static final long serialVersionUID = -5360587050973021953L;
	
	private double [] _features;
	private int _featureClass;
	
	public FeatureVector(double [] features, int featureClass) {
		_features = features;
		_featureClass = featureClass;
	}
	
	public double [] getFeatures() {
		return _features;
	}
	
	public int getFeatureClass() {
		return _featureClass;
	}
	
	public void setFeatureClass(int newFeatureClass) {
		_featureClass = newFeatureClass;
	}
	
	public double calcEuclideanDist(FeatureVector otherFv) {
		
		double distance = 0.0;
		double [] otherFvFeatures = otherFv.getFeatures();
		
		for(int i = 0; i < 16; i ++) {
			double value = (_features[i] - otherFvFeatures[i]);
			distance += value * value;
		}
		
		distance = Math.sqrt(distance);		
		
		return distance;
	}
	
	public double calcStdEuclideanDist(FeatureVector otherFv, double [] stdDevArr) {
		
		double distance = 0.0;
		double [] otherFvFeatures = otherFv.getFeatures();
		
		for(int i = 0; i < 16; i ++) {
			double value = (_features[i] - otherFvFeatures[i]) / stdDevArr[i];
			distance += value * value;
		}
		
		distance = Math.sqrt(distance);		
		
		return distance;
	}
	
	public String toString() {
		
		String s = "";
		for(double feature : _features) {
			s += String.format("%5.3f, ", feature);
		}
		
		s += "Class Label: " + _featureClass + (_featureClass == 1 ? "(Focus)" : "(Relax)");
		
		return s;
	}
}
