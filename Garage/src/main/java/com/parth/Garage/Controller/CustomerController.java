package com.parth.Garage.Controller;

import com.parth.Garage.Service.CustomerService;
import com.parth.Garage.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;


    public CustomerController(CustomerService service){ this.service = service; }


    @GetMapping
    public List<Customer> all(){ return service.listAll(); }


    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id){ return service.get(id); }


    @PostMapping
    public Customer create(@RequestBody Customer c){ return service.create(c); }


    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer c){ return service.update(id, c); }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}