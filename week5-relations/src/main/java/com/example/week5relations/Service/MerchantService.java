package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Model.Merchant;
import com.example.week5relations.Repository.CustomerRepository;
import com.example.week5relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    public List<Merchant> getAll(){

        return merchantRepository.findAll();
    }
    public void assignedcustomertomerchant(Integer merchant_id,Integer customer_id){
        Merchant merchant=merchantRepository.findMerchantById(merchant_id);
        Customer customer=customerRepository.findCustomerById(customer_id);
        if(merchant==null || customer==null){
            throw new ApiException("id not found");
        }
        merchant.getCustomerset().add(customer);
        customer.getMerchantSet().add(merchant);
        merchantRepository.save(merchant);
        customerRepository.save(customer);

    }


    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant merchant){
        Merchant oldmerhcnat=merchantRepository.findMerchantById(id);
        if(oldmerhcnat==null){
            throw new ApiException("id not found");
        }
        oldmerhcnat.setName(merchant.getName());
        merchantRepository.save(oldmerhcnat);

    }

    public void deleteMerchant(Integer id){
        Merchant oldmerchant=merchantRepository.findMerchantById(id);
        if(oldmerchant==null){
            throw new ApiException("id not found");
        }

        merchantRepository.deleteById(id);
    }
}
