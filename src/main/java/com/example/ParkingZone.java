package com.example;

import java.util.ArrayList;

public class ParkingZone {

    private String zoneName;
    private Integer capacity;

    public ParkingZone(String zoneName, Integer capacity) {
        this.zoneName = zoneName;
        this.capacity = capacity;
        this.cars = new ArrayList();
    }

    public String getZoneName() {
        return zoneName;
    }

    private ArrayList<String> cars;

    public void parkCar(String plateNumber) {
        if(cars.size()<capacity){
            cars.add(plateNumber);
            System.out.print("New car was added.");
        }
        else{
            System.out.print("Parking Zone if full.");
        }
    }

    public void removeCar(String plateNumber) {
        if(cars.contains(plateNumber)){
            cars.remove(plateNumber);
            System.out.println("Car was removed.");
        }
        else{
            System.out.println("This plate number does not exist.");
        }
    }

    public void showParkedCars(){
        for(int i=0; i<cars.size(); i++){
            System.out.println((i+1) + "." + cars.get(i));
        }
        System.out.println("Cars count: " + cars.size());
    }
}
