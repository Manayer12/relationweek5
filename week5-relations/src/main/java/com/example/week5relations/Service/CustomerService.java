package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){

        return customerRepository.findAll();
    }


    public void addcustomer(Customer customer){
        customerRepository.save(customer);
    }



    public void updatecustomer(Integer id, Customer customer){
        Customer oldcustomer=customerRepository.findCustomerById(id);
        if(oldcustomer==null){
            throw new ApiException("id not found");
        }

        oldcustomer.setName(customer.getName());
        customerRepository.save(oldcustomer);

    }
    public void deletecustomer(Integer id){
        Customer oldcustomer=customerRepository.findCustomerById(id);
        if(oldcustomer==null){
            throw new ApiException("id not found");
        }


       customerRepository.deleteById(id);
    }




}
