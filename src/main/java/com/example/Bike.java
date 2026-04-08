package com.example;

public class Bike {
    private int id; // ID field zaroori hai database se data lane ke liye
    private String name;
    private String brand;
    private int avgSpeed;
    private double price;

    // Default Constructor
    public Bike() {}

    // Constructor with ID (Ye missing tha isliye error aa raha tha)
    public Bike(int id, String name, String brand, int avgSpeed, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.avgSpeed = avgSpeed;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public int getAvgSpeed() { return avgSpeed; }
    public double getPrice() { return price; }

    // Methods
    public void start() {
        System.out.println(brand + " " + name + " started");
    }

    public void move() {
        System.out.println(brand + " " + name + " moving at " + avgSpeed);
    }

    public void stop() {
        System.out.println(brand + " " + name + " stopped");
    }

    public void printBike() {
        System.out.println(id + ". " + name + " " + brand + " Speed:" + avgSpeed + " Price:" + price);
    }
}