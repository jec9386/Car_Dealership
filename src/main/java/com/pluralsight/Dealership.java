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

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    //methods---------------------------------------------------------------------------------------------------------
    public List<Vehicle> getVehicleByPrice(double min, double max){
        ArrayList<Vehicle> price = new ArrayList<>();
        for(Vehicle p: inventory){
            if(p.getPrice() <= max && p.getPrice() >= min){
                price.add(p);
            }
        }
        return price;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        ArrayList<Vehicle> makeModel = new ArrayList<>();
        for(Vehicle m: inventory){
            if(m.getMake().equalsIgnoreCase(make) && m.getModel().equalsIgnoreCase(model)){
                makeModel.add(m);
            }
        }
        return makeModel;
    }

    public List<Vehicle> getVehicleByYear(double min, double max){
        ArrayList<Vehicle> year = new ArrayList<>();
        for(Vehicle y: inventory){
            if(y.getYear() >= min && y.getYear()<= max){
                year.add(y);
            }
        }
        return year;
    }

    public List<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> vehicleColor = new ArrayList<>();
        for(Vehicle c: inventory){
            if(c.getColor().equalsIgnoreCase(color)){
                vehicleColor.add(c);
            }
        }
        return vehicleColor;
    }

    public List<Vehicle> getVehicleByMileage(double min, double max){
        ArrayList<Vehicle> mileage = new ArrayList<>();
        for(Vehicle m: inventory){
            if(m.getOdometer() >= min && m.getOdometer()<= max){
                mileage.add(m);
            }
        }
        return mileage;
    }

    public List<Vehicle> getVehicleByType(String type){
        ArrayList<Vehicle> vehicleType = new ArrayList<>();
        for(Vehicle t: inventory){
            if(t.getVehicleType().equalsIgnoreCase(type)){
                vehicleType.add(t);
            }
        }
        return vehicleType;
    }

    public Vehicle getVehicleByVin(int vin){
        for(Vehicle v: inventory){
            if (v.getVin() == vin){
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }



//    INITIAL TRIAL public boolean removeVehicleByVin(int vin){
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getVin() == vin) {
//                inventory.remove(vehicle);
//                return true; // success
//            }
//        }
//        return false;
//    }

    @Override
    public String toString() {

        return "Name: " + name + "| Address: " + address + "| Phone Number: " + phone + "\n" + inventory;

    }

    public String toCSV() {
        return name + "|" + address + "|" + phone;
    }



}