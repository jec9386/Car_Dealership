package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory ;//declares a field, that holds a list of Vehicle objects, only declared nothing created.

    // Constructor----------------------------------------------------------------------------------------------------
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>(); //when constructor called upon and an object is created, the actual list will instantiated(created) adn assigns it to the inventory instance variable.
    }

    //getter and setter-----------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //methods---------------------------------------------------------------------------------------------------------
    public List<Vehicle> getVehicleByPrice(double min, double max){
        return null;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehicleByYear(double min, double max){
        return null;
    }

    public List<Vehicle> getVehicleByColor(String color){
        return null;
    }

    public List<Vehicle> getVehicleByMileage(double min, double max){
        return null;
    }

    public List<Vehicle> getVehicleByType(double min, double max){
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }


    public void removeVehicle(Vehicle vehicle){
        //inventory.remove(vehicle);
    }

}