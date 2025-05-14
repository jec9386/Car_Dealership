package com.pluralsight;


import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private Dealership dealership;//create a placeholder
    private DealershipFileManager fileManager;

    private void init() {
         DealershipFileManager fileManager = new DealershipFileManager("inventory.csv");
         dealership = fileManager.getDealership();
    }

    public void display(){
        init();//method to load the dealership from the file

        do{
            int choice = displayMenu();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehiclesRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return; // Exit
                default:
                    System.out.println("Invalid option. Try again.");
            }

            try {
                Thread.sleep(3000); // <--- Add pause here
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } while (true);
    }

    public int displayMenu(){
            String requestVehicle =
                    "                  Request Vehicle By                  \n" +
                            "------------------------------------------------\n" +
                            "Please select a search option:\n" +
                            "    1 - Price\n" +
                            "    2 - MakeModel\n" +
                            "    3 - Year\n" +
                            "    4 - Color\n" +
                            "    5 - Mileage\n" +
                            "    6 - Vehicle Type\n" +
                            "    7 - All Vehicle\n" +
                            "    8 - Add Vehicle\n" +
                            "    9 - Remove Vehicle\n" +
                            "    0 - Exit\n" +
                            "Select an option (1-9, or 0 to exit): ";
        return Console.promptForInt(requestVehicle);



    }

    public void displayVehicles(List<Vehicle> vehicles){
        for (Vehicle vehicle :vehicles){
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest(){
        Double minPrice = Console.promptForDouble("Please enter the min price of car: ");

        Double maxPrice = Console.promptForDouble("Please enter the max price of car: ");

        List<Vehicle> v = dealership.getVehicleByPrice(minPrice, maxPrice);

        displayVehicles(v);

    }

    public void processGetByMakeModelRequest(){
        String make = Console.promptForString("Please enter the make of car: ");

        String model = Console.promptForString("Please enter the model of car: ");

        List<Vehicle> v = dealership.getVehicleByMakeModel(make, model);

        displayVehicles(v);
    }

    public void processGetByYearRequest(){
        Integer minYear = Console.promptForInt("Please enter the min year of car: ");

        Integer maxYear = Console.promptForInt("Please enter the max year of car: ");

        List<Vehicle> v = dealership.getVehicleByYear(minYear, maxYear);

        displayVehicles(v);
    }

    public void processGetByColorRequest(){
        String color = Console.promptForString("Please enter the color of car: ");

        List<Vehicle> v = dealership.getVehicleByColor(color);

        displayVehicles(v);
    }

    public void processGetByMileageRequest(){
        Integer minMileage = Console.promptForInt("Please enter the min mileage of car: ");

        Integer maxMileage = Console.promptForInt("Please enter the max mileage of car: ");

        List<Vehicle> v = dealership.getVehicleByMileage(minMileage, maxMileage);

        displayVehicles(v);
    }

    public void processGetByVehicleTypeRequest(){
        String type = Console.promptForString("Please enter the type of car: ");

        List<Vehicle> v = dealership.getVehicleByType(type);

        displayVehicles(v);
    }

    public void processGetAllVehicleRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    public void processAddVehiclesRequest(){
        int vin = Console.promptForInt("Enter VIN: ");
        int year = Console.promptForInt("Enter year: ");
        String make = Console.promptForString("Enter make: ");
        String model = Console.promptForString("Enter model: ");
        String type = Console.promptForString("Enter type: ");
        String color = Console.promptForString("Enter color: ");
        int odometer = Console.promptForInt("Enter odometer reading: ");
        double price = Console.promptForDouble("Enter price: ");

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        System.out.println("Vehicle added and saved successfully!");

        fileManager = new DealershipFileManager("inventory.csv");
        fileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest(){
        int vin = Console.promptForInt("Enter the VIN of the vehicle to remove: ");

        Vehicle v = dealership.getVehicleByVin(vin);

        if(v != null){
            //remove here.
            dealership.removeVehicle(v);
            System.out.println("Vehicle removed successfully.");
            fileManager = new DealershipFileManager("inventory.csv");
            fileManager.saveDealership(dealership);
        }
        else{
            System.out.println("No vehicle found with VIN: " + vin);
        }

    }





}
