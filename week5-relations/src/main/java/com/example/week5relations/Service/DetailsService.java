package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.DTO.CustomerDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.CustomerDetails;
import com.example.week5relations.Repository.CustomerDetailsRepository;
import com.example.week5relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailsService {
final private CustomerRepository customerRepository;
private final CustomerDetailsRepository customerDetailsRepository;
    public void adddetails(CustomerDTO customerDTO){
        Customer customer=customerRepository.findCustomerById(customerDTO.getCustomer_id());

        if (customer == null){
            throw new ApiException("id is null");
        }
        CustomerDetails customerDetails=new CustomerDetails(null,customerDTO.getGender(),customerDTO.getAge(),customerDTO.getEmail(),customer);
     customerDetailsRepository.save(customerDetails);
    }
}
