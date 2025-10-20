package com.parth.Garage.Service;


import com.parth.Garage.Repository.MechanicRepository;
import com.parth.Garage.entity.Mechanic;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MechanicService {
    private final MechanicRepository repo;
    public MechanicService(MechanicRepository repo){ this.repo = repo; }

    public List<Mechanic> listAll(){ return repo.findAll(); }
    public Mechanic create(Mechanic m){ return repo.save(m); }
    public Mechanic update(Long id, Mechanic m){
        Mechanic existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Mechanic not found"));
        existing.setName(m.getName());
        existing.setPhone(m.getPhone());
        existing.setSpecialization(m.getSpecialization());
        return repo.save(existing);
    }
    public void delete(Long id){ repo.deleteById(id); }
}