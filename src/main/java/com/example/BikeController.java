//Yahan humne @DeleteMapping add kiya hai jo JS ki request ko handle karega.

package com.example;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bikes")
@CrossOrigin(origins = "*") 
public class BikeController {

    private BikeDAO dao = new BikeDAO();

    @GetMapping
    public List<Bike> getBikes() {
        return dao.getAllBikes();
    }

    @PostMapping
    public String addBike(@RequestBody Bike bike) {
        dao.addBike(bike);
        return "Bike added successfully!";
    }

    // Naya Delete Route
    @DeleteMapping("/{id}")
    public String deleteBike(@PathVariable int id) {
        dao.deleteBike(id);
        return "Bike deleted successfully!";
    }
}