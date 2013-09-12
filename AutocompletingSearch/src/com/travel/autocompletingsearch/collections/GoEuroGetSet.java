package com.travel.autocompletingsearch.collections;

import com.travel.autocompletingsearch.operations.Distance;
/**
 * 
 * @author munish
 * GoEuroGetSet Getter Setter methods 
 */
public class GoEuroGetSet {

	String _type,_id,name,type;
	String longitude,latitude;
	double distance;
	
	public GoEuroGetSet(double current_latitude,double current_longitude,String _type,String _id,String name,String type,String latitude,String longitude){
	this.set_type(_type);
	this.set_id(_id);
	this.setName(name);
	this.setType(type);
	this.setLatitude(latitude);
	this.setLongitude(longitude);
	this.setDistance(Distance.distFrom(current_latitude,current_longitude,Double.parseDouble(latitude),Double.parseDouble(longitude)));
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
