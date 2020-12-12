package com.codingdojo.phone;

public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
		String ring = "This Galaxy " + this.getVersionNumber() + " is provided by:  " + this.getCarrier() + " has a ringtone of " + this.getRingTone();
		return ring;
    }
    @Override
    public String unlock() {
    	return "Unlocking via finger print recognition";
    }
    @Override
    public void displayInfo() {
		System.out.println("This Galaxy " + this.getVersionNumber() + " is provided by: " + this.getCarrier());
		return;
    }
}
