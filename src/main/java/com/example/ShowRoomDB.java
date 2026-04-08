package com.example;

import java.util.ArrayList;

public class ShowRoomDB {

    public void run() {
        BikeDAO dao = new BikeDAO();

        // Pehle: new Bike("Pulsar", "Bajaj", 100, 85000.99) tha
        // Ab: 0 add kar diya constructor ke shuru mein
        Bike bike1 = new Bike(0, "Pulsar", "Bajaj", 100, 85000.99);
        dao.addBike(bike1);

        ArrayList<Bike> bikes = dao.getAllBikes();
        for (Bike bike : bikes) {
            bike.printBike();
        }
    }
}