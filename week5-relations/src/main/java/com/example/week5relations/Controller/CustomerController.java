package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(customerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
        customerService.addcustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Customer customer){
        customerService.updatecustomer(id, customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer updated"));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        customerService.deletecustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("customer deleted"));
    }



}
