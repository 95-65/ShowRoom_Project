//Yahan getAllBikes mein ID fetch ho rahi hai aur deleteBike ka naya method add kiya hai.
package com.example;

import java.sql.*;
import java.util.ArrayList;

public class BikeDAO {

    // 1. Delete bike logic (Naya Method)
    public void deleteBike(int id) {
        String sql = "DELETE FROM bikes WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Add bike logic (Same as before)
    public void addBike(Bike bike) {
        String sql = "INSERT INTO bikes (brand, name, avgSpeed, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, bike.getBrand());
            stmt.setString(2, bike.getName());
            stmt.setInt(3, bike.getAvgSpeed());
            stmt.setDouble(4, bike.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Get all bikes (ID fetch karne ke liye update kiya)
    public ArrayList<Bike> getAllBikes() {
        ArrayList<Bike> bikes = new ArrayList<>();
        String sql = "SELECT * FROM bikes";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Bike bike = new Bike(
                        rs.getInt("id"), // Database se ID nikaalna zaroori hai
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getInt("avgSpeed"),
                        rs.getDouble("price")
                );
                bikes.add(bike);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bikes;
    }
}