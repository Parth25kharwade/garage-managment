package com.parth.Garage.Service;


import com.parth.Garage.Repository.CustomerRepository;
import com.parth.Garage.entity.Customer;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CustomerService {
    private final CustomerRepository repo;
    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public List<Customer> listAll(){ return repo.findAll(); }
    public Customer get(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found")); }
    public Customer create(Customer c){ return repo.save(c); }
    public Customer update(Long id, Customer c){
        Customer existing = get(id);
        existing.setName(c.getName());
        existing.setPhone(c.getPhone());
        existing.setEmail(c.getEmail());
        existing.setAddress(c.getAddress());
        return repo.save(existing);
    }
    public void delete(Long id){ repo.deleteById(id); }
}