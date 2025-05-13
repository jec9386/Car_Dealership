package com.pluralsight;


import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private static Dealership dealership;//create a placeholder

    private static void init() {
         DealershipFileManager fileManager = new DealershipFileManager("inventory.csv");
         dealership = fileManager.getDealership();
    }

    public static void display(){
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

    public static void processGetByPriceRequest(){
        Double minPrice = Console.promptForDouble("Please enter the min price of car: ");

        Double maxPrice = Console.promptForDouble("Please enter the max price of car: ");

        List<Vehicle> v = dealership.getVehicleByPrice(minPrice, maxPrice);

        System.out.println(v.toString());

    }

//    public void processGetByMakeModelRequest(){
//
//    }
//
//    public void processGetByYearRequest(){
//
//    }
//
//    public void processGetByColorRequest(){
//
//    }
//
//    public void processGetByMileageRequest(){
//
//    }
//
//    public void processGetByVehicleTypeRequest(){
//
//    }
//
    public void processGetAllVehicleRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }
//
//    public void processAddVehiclesRequest(){
//
//    }
//
//    public void processRemoveVehicleRequest(){
//
//    }
//
//
//
//
//
}
