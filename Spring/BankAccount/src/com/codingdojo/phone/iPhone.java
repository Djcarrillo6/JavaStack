package com.codingdojo.phone;

public class iPhone extends Phone implements Ringable{
    public iPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String ring ="This iPhone " + this.getVersionNumber() + " has of rintone of: " + this.getRingTone();
        return ring;
    }
    @Override
    public String unlock() {
        return "Unlock via facial recognition ID";
    }
    @Override
    public void displayInfo() {
        System.out.println("This iPhone " + this.getVersionNumber() + "is provided by: " + this.getCarrier());           
    }
}
