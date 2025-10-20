package com.parth.Garage.Controller;

import com.parth.Garage.Service.MechanicService;
import com.parth.Garage.entity.Mechanic;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mechanics")
public class MechanicController {
    private final MechanicService service;
    public MechanicController(MechanicService service){ this.service = service; }

    @GetMapping public List<Mechanic> all(){ return service.listAll(); }
    @PostMapping public Mechanic create(@RequestBody Mechanic m){ return service.create(m); }
    @PutMapping("/{id}") public Mechanic update(@PathVariable Long id, @RequestBody Mechanic m){ return service.update(id, m); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}