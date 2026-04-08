package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {
    private Scanner sc = new Scanner(System.in);

    // Validate string (letters and spaces only)
    private String getValidString(String fieldName) {
        String input;
        while (true) {
            System.out.print(fieldName + ": ");
            input = sc.nextLine();
            if (input.matches("[a-zA-Z ]+")) break;
            System.out.println("Invalid input! Enter letters only for " + fieldName);
        }
        return input;
    }

    // Validate positive integer
    private int getPositiveInt(String fieldName) {
        int value;
        while (true) {
            System.out.print(fieldName + ": ");
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value > 0) break;
                else System.out.println(fieldName + " must be positive.");
            } else {
                System.out.println("Invalid input! Enter a number for " + fieldName);
                sc.nextLine();
            }
        }
        return value;
    }

    // Validate positive double
    private double getPositiveDouble(String fieldName) {
        double value;
        while (true) {
            System.out.print(fieldName + ": ");
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();
                if (value > 0) break;
                else System.out.println(fieldName + " must be positive.");
            } else {
                System.out.println("Invalid input! Enter a number for " + fieldName);
                sc.nextLine();
            }
        }
        return value;
    }

    // Create bikes dynamically
    public ArrayList<Bike> createBikes() {
        ArrayList<Bike> bikes = new ArrayList<>();
        int n = getPositiveInt("Number of bikes to add");

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for bike " + (i + 1));
            String brand = getValidString("Brand");
            String name = getValidString("Name");
            int speed = getPositiveInt("Average Speed");
            double price = getPositiveDouble("Price");


            // Pehle: bikes.add(new Bike(name, brand, speed, price));
           // Ab isse replace karein (humne bas shuru mein '0,' lagaya hai):
            bikes.add(new Bike(0,name, brand, speed, price));
        }
        return bikes;
    }
}