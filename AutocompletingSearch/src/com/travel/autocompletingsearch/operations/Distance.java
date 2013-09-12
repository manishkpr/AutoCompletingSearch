package com.travel.autocompletingsearch.operations;
/**
 * 
 * @author munish
 * This class use to get distance in meteres
 */
public class Distance {

	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return roundDistance(dist);
	    }
	public static double roundDistance(double value){
		double finalValue = Math.round( value * 100.0 ) / 100.0;
		return finalValue;
	}

}
