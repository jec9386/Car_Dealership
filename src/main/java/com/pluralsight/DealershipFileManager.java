package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    //make instance so other dealerships can use their own file
    private String fileName;

    //constructor
    public DealershipFileManager(String fileName){
        this.fileName = fileName;
    }

    //Getter and setter


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //method-----------------------------------------------------------------------------------------------
    public Dealership getDealership(){//return a Dealership object
        //return a Dealership object
        // Declare a Dealership variable
        Dealership dealership = null;//placeholder for Dealership object


        // Open file with FileReader and BufferedReader is a helper that reads through each line of the file
        try(FileReader fileReader = new FileReader(this.fileName); BufferedReader reader = new BufferedReader(fileReader)){

            String line;//read the first line of the file
            if((line = reader.readLine()) != null){//readLine() reads 1 line of text from file, if there is a line it stores it in line variable- keeps reading until there is no more lines.
                String[] parts = line.split("\\|"); //split by pipe
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];
                dealership = new Dealership(name, address, phone);//constructor used to create the new dealership

            }


            // Read vehicle info (remaining lines)
            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|"); //vehicle data
                int vin = Integer.parseInt(data[0]); // convert the Strings to actual numbers
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);//create new vehicle object
                dealership.addVehicle(vehicle);// add this object to the dealership inventory
            }
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());//helps print an error message instead of crashing the program
        }
        return dealership;//built dealership object now you can view it
    }

//    public void saveDealership(dealership){
//      TODO
//    }



}
