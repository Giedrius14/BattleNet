package com.battle.net.dao;

public class Calculation {
	
	private Double litersFuel;
	private Double distance;
	private Double sum;
	
	public Double getLitersFuel() {
		return litersFuel;
	}
	public void setLitersFuel(Double litersFuel) {
		this.litersFuel = litersFuel;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getSum() {
		sum= (litersFuel/ distance)*100;
		return sum ;
	}



}
