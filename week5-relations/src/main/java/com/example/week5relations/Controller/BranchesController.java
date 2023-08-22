package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.Model.Branche;
import com.example.week5relations.Model.Merchant;
import com.example.week5relations.Service.BranchesService;
import com.example.week5relations.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branche")
@RequiredArgsConstructor
public class BranchesController {

    private final BranchesService branchesService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(branchesService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Branche branche){
        branchesService.addBranches(branche);
        return ResponseEntity.status(200).body(new ApiResponse("branche added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Branche branche ){
        branchesService.updateBranchs(id, branche);
        return ResponseEntity.status(200).body(new ApiResponse("branche updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        branchesService.deleteBranche(id);
        return ResponseEntity.status(200).body(new ApiResponse("branche deleted"));
    }

    @PutMapping("/{merchant_id}/assign/{branche_id}")
    public ResponseEntity assignMerchantToBranch(@PathVariable Integer merchant_id,@PathVariable Integer branche_id){
        branchesService.assignMerchantToBranch(merchant_id,branche_id);
        return ResponseEntity.status(200).body(new ApiResponse("branch assigned to merchant"));

    }



}
