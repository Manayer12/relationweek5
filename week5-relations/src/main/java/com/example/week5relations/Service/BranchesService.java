package com.example.week5relations.Service;

import com.example.week5relations.Api.ApiException;
import com.example.week5relations.Model.Branche;
import com.example.week5relations.Model.Merchant;
import com.example.week5relations.Repository.BranchesRepository;
import com.example.week5relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchesService {

    private final BranchesRepository branchesRepository;
    private final MerchantRepository merchantRepository;
    public List<Branche> getAll(){

        return branchesRepository.findAll();
    }

    public void addBranches(Branche branche){
        branchesRepository.save(branche);

    }

    public void updateBranchs(Integer id, Branche branche){
        Branche oldBranche=branchesRepository.findBranchesById(id);
        if(oldBranche==null){
            throw new ApiException("id not found");
        }

        oldBranche.setNumber(branche.getNumber());
        oldBranche.setArea(branche.getArea());
        branchesRepository.save(oldBranche);

    }

    public void deleteBranche(Integer id){
        Branche oldBranche=branchesRepository.findBranchesById(id);
        if(oldBranche==null){
            throw new ApiException("id not found");
        }

        branchesRepository.deleteById(id);
    }

    //Assign one to many relation(merchant -branche)
    public void assignMerchantToBranch(Integer merchant_id,Integer branche_id){
        Branche branche=branchesRepository.findBranchesById(branche_id);
        Merchant merchant=merchantRepository.findMerchantById(merchant_id);

        if (branche==null || merchant==null){

            throw  new ApiException("Can not Assign");
        }
        branche.setMerchant(merchant);
        branchesRepository.save(branche);
    }
}
