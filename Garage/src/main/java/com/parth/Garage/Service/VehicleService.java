package com.parth.Garage.Service;

import com.parth.Garage.Repository.CustomerRepository;
import com.parth.Garage.Repository.VehicleRepository;
import com.parth.Garage.entity.Customer;
import com.parth.Garage.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository repo;
    private final CustomerRepository customerRepo;

    public VehicleService(VehicleRepository repo, CustomerRepository customerRepo){
        this.repo = repo; this.customerRepo = customerRepo;
    }

    public List<Vehicle> listAll(){ return repo.findAll(); }

    public Vehicle create(Vehicle v){
        if(v.getOwner() != null){
            Customer owner = customerRepo.findById(v.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Owner not found"));
            v.setOwner(owner);
        }
        return repo.save(v);
    }

    public Vehicle update(Long id, Vehicle v){
        Vehicle existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        existing.setMake(v.getMake());
        existing.setModel(v.getModel());
        existing.setRegistrationNumber(v.getRegistrationNumber());
        existing.setYear(v.getYear());
        return repo.save(existing);
    }

    public void delete(Long id){ repo.deleteById(id); }
}