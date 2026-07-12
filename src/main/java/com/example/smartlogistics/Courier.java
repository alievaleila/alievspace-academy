package com.example.smartlogistics;

import java.util.ArrayList;

public class Courier {

    private int courierId;
    private String name;
    private String vehicleType;
    private ArrayList<Parcel> assignedParcels;
    private boolean isActive;

    public Courier(int courierId, String name, String vehicleType) {
        this.courierId = courierId;
        this.name = name;
        this.vehicleType = vehicleType;
        this.assignedParcels = new ArrayList<>();
        this.isActive = true;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ArrayList<Parcel> getAssignedParcels() {
        return assignedParcels;
    }

    public void setAssignedParcels(ArrayList<Parcel> assignedParcels) {
        this.assignedParcels = assignedParcels;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void addAssignedParcel(Parcel parcel) {
        this.assignedParcels.add(parcel);
    }
}
