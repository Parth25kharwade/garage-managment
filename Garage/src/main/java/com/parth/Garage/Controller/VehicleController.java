package com.parth.Garage.Controller;


import com.parth.Garage.Service.VehicleService;
import com.parth.Garage.entity.Vehicle;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService service;
    public VehicleController(VehicleService service){ this.service = service; }

    @GetMapping public List<Vehicle> all(){ return service.listAll(); }
    @PostMapping public Vehicle create(@RequestBody Vehicle v){ return service.create(v); }
    @PutMapping("/{id}") public Vehicle update(@PathVariable Long id, @RequestBody Vehicle v){ return service.update(id, v); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}