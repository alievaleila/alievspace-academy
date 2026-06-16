package com.example.smart_logistics;

import java.util.ArrayList;
import java.util.Random;

public class LogisticsManager {

    private final ArrayList<Courier> couriers;

    public LogisticsManager() {
        this.couriers = new ArrayList<>();
    }

    public void addCourier(Courier courier) {
        this.couriers.add(courier);
    }

    public String generateCode(String city, double weight) {
        String prefix = "";
        city = city.trim();

        if (city.length() >= 3) {
            prefix = city.substring(0, 3).toUpperCase();
        } else {
            prefix = city.toUpperCase();

            while (city.length() < 3) {
                prefix += "X";
            }
        }

        int intweight = (int) weight;

        Random rand = new Random();

        int randomNumber = rand.nextInt(900) + 100;

        return prefix + "-" + intweight + "-" + randomNumber;
    }

    public double calculateCost(Parcel parcel) {

        double baseCost = 0;
        String city = parcel.getDestinationCity().trim();

        switch (city.trim()) {
            case "baku":
            case "bakı":
                baseCost = 5.0;
                break;
            case "ganja":
            case "gəncə":
                baseCost = 10.0;
                break;
            default:
                baseCost = 15.0;
                break;
        }

        if (parcel.getWeight() > 10 && !city.equalsIgnoreCase("baku") && !city.equalsIgnoreCase("bakı")) {
            baseCost += (parcel.getWeight() * 1.5);
        }

        return baseCost;
    }

    public double calculateCost(Parcel parcel, String courierVehicle) {

        if (courierVehicle == null) {
            return calculateCost(parcel);
        }

        switch (courierVehicle.toLowerCase()) {
            case "moto":
                return calculateCost(parcel);
            case "car":
                return calculateCost(parcel) * 1.2;
            default:
                return calculateCost(parcel);
        }
    }

    public void assignParcelToBestCourier(Parcel parcel) {
        if (parcel.getWeight() <= 0) {
            throw new IllegalArgumentException("Error: Parcel weight cannot be negative or zero! Provided weight: "
                    + parcel.getWeight());
        }

        boolean assigned = false;

        for (Courier courier : couriers) {
            String vehicle = courier.getVehicleType().toLowerCase();

            if (courier.isActive() &&
                    (vehicle.equals("car") || vehicle.equals("moto")) &&
                    courier.getAssignedParcels().size() < 5) {

                courier.addAssignedParcel(parcel);

                parcel.setStatus("In_Progress");
                System.out.println("[SUCCESSFUL ASSIGNMENT] Parcel with tracking code " + parcel.getTrackingCode() +
                        " has been assigned to courier " + courier.getName() + " (" + courier.getVehicleType() + ").");
                assigned = true;
                break;
            }
        }

        if (!assigned) {
            System.out.println("[WARNING] No suitable or available courier found for tracking code " + parcel.getTrackingCode() + ".");
        }
    }
}

