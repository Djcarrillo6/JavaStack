package com.codingdojo.ninjagold;

public class MyString {
	
	String location;
	String text;
	String color;
	String gained;
	String posOrNeg;
	String timeStamp;
	public String getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	int gold;
	

	// Constructor
	public MyString(
			String text, 
			String color, 
			String location, 
			String gained, 
			String posOrNeg,
			String timeStamp) {
		
		this.text = text;
		this.color = color;
		this.location = location;
		this.gained = gained;
		this.posOrNeg = posOrNeg;
		this.timeStamp = timeStamp;
	}
	
	
	
	// Getters/Setters
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGained() {
		return gained;
	}

	public void setGained(String gained) {
		this.gained = gained;
	}

	public String getPosOrNeg() {
		return posOrNeg;
	}

	public void setPosOrNeg(String posOrNeg) {
		this.posOrNeg = posOrNeg;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
