package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowRoom {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Factory factory = new Factory();
        ArrayList<Bike> bikes = factory.createBikes();

        while (true) {
            System.out.println("\n=== ShowRoom Menu ===");
            System.out.println("1. List all bikes");
            System.out.println("2. Start a bike");
            System.out.println("3. Move a bike");
            System.out.println("4. Stop a bike");
            System.out.println("5. Add a new bike");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (sc.hasNextInt()) choice = sc.nextInt();
            else {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Bikes:");
                    for (int i = 0; i < bikes.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        bikes.get(i).printBike();
                    }
                    break;

                case 2:
                case 3:
                case 4:
                    if (bikes.size() == 0) {
                        System.out.println("No bikes available.");
                        break;
                    }

                    int index = -1;
                    while (true) {
                        System.out.print("Enter bike number (1 to " + bikes.size() + "): ");
                        if (sc.hasNextInt()) {
                            index = sc.nextInt() - 1;
                            sc.nextLine();
                            if (index >= 0 && index < bikes.size()) break;
                        } else sc.nextLine();
                        System.out.println("Invalid input!");
                    }

                    Bike selectedBike = bikes.get(index);
                    if (choice == 2) selectedBike.start();
                    else if (choice == 3) selectedBike.move();
                    else selectedBike.stop();
                    break;

                case 5:
                    bikes.addAll(factory.createBikes());
                    break;

                case 6:
                    System.out.println("Exiting ShowRoom. THANK YOU!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}