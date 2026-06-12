package com.example.smart_home;

public class SmartDevice {

    private String deviceName;
    private Boolean isOn;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public void turnOn() {
        if (isOn) {
            System.out.println("The device is turned on");
        }

    }
}
