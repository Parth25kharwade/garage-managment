package com.parth.Garage.Service;


import com.parth.Garage.Dto.AppointmentDto;
import com.parth.Garage.Repository.AppointmentRepository;
import com.parth.Garage.Repository.MechanicRepository;
import com.parth.Garage.Repository.VehicleRepository;
import com.parth.Garage.entity.Appointment;
import com.parth.Garage.entity.Mechanic;
import com.parth.Garage.entity.Vehicle;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;
    private final VehicleRepository vehicleRepo;
    private final MechanicRepository mechanicRepo;

    public AppointmentService(AppointmentRepository repo, VehicleRepository vehicleRepo, MechanicRepository mechanicRepo){
        this.repo = repo; this.vehicleRepo = vehicleRepo; this.mechanicRepo = mechanicRepo;
    }

    public List<Appointment> listAll(){ return repo.findAll(); }

    public Appointment create(AppointmentDto dto){
        Vehicle v = vehicleRepo.findById(dto.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Mechanic m = mechanicRepo.findById(dto.getMechanicId()).orElseThrow(() -> new RuntimeException("Mechanic not found"));

        Appointment a = Appointment.builder()
                .vehicle(v)
                .mechanic(m)
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .status("SCHEDULED")
                .notes(dto.getNotes())
                .build();
        return repo.save(a);
    }

    public Appointment updateStatus(Long id, Appointment a){
        Appointment existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        existing.setStatus(a.getStatus());
        existing.setNotes(a.getNotes());
        return repo.save(existing);
    }

    public void delete(Long id){ repo.deleteById(id); }
}