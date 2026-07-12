package com.example.smartlogistics;

import java.util.UUID;

public class Parcel {

    private final String trackingCode;
    private double weight;
    private String destinationCity;
    private String status;

    public Parcel(String trackingCode, double weight, String destinationCity, String status) {
        this.trackingCode = trackingCode;
        this.weight = weight;
        this.destinationCity = destinationCity;
        this.status = status;
    }

    public Parcel(double weight, String destinationCity) {
        this.weight = weight;
        this.destinationCity = destinationCity;
        this.trackingCode = "TRK-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        this.status = "Pending";
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "trackingCode='" + trackingCode + '\'' +
                ", weight=" + weight +
                ", destinationCity='" + destinationCity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
