package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.DTO.CustomerDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.CustomerDetails;
import com.example.week5relations.Repository.CustomerDetailsRepository;
import com.example.week5relations.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public List<CustomerDetails> getAll(){

        return customerDetailsRepository.findAll();
    }


    public void updateDetails(Integer id,CustomerDTO customerDTO){
        CustomerDetails customerDetails=customerDetailsRepository.findCustomerDetailsById(id);
        if(customerDetails==null){
            throw new ApiException("id not found");
        }
        customerDetails.setGender(customerDTO.getGender());
        customerDetails.setAge(customerDTO.getAge());
        customerDetails.setEmail(customerDTO.getEmail());
        customerDetailsRepository.save(customerDetails);

    }
    public void deleteDetails(Integer id){

        CustomerDetails customerDetails=customerDetailsRepository.findCustomerDetailsById(id);
        Customer customer=customerRepository.findCustomerById(id);
        if(customerDetails == null || customer == null){
            throw new ApiException("id not found");
        }
        //the details can not be deleted until the customer deleted
<<<<<<< HEAD

          customerRepository.deleteById(id);
          customerDetailsRepository.deleteById(id);
=======
          // customerRepository.deleteById(id);
          // customerDetailsRepository.deleteById(id);
        customerDetailsRepository.deleteAllByIdInBatch(Collections.singleton(id));
>>>>>>> 15eecdb2fe57cccd631af9ba2b50996d386cf7d8
    }

}
