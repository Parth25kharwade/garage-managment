package com.parth.Garage.Controller;

import com.parth.Garage.Dto.AppointmentDto;
import com.parth.Garage.Service.AppointmentService;
import com.parth.Garage.entity.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class AppointmentController {
    private final AppointmentService service;
    AppointmentController(AppointmentService service) { this.service = service; }

    @GetMapping
    List<Appointment> all() { return service.listAll(); }

    @PostMapping
    Appointment create(AppointmentDto appointment) { return service.create(appointment); }

    @PutMapping("{id}")
    Appointment update(@PathVariable("id") long id, Appointment appointment){return service.updateStatus(id,appointment);}

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") long id){
        service.delete(id);
    }

}
