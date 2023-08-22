package com.example.week5relations.Controller;
import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.Model.Merchant;
import com.example.week5relations.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController{

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(merchantService.getAll());
    }

    @GetMapping("/{merchant_id}/assign/{customer_id}")
    private ResponseEntity assigncustomertomerchant(@PathVariable Integer merchant_id,@PathVariable Integer customer_id){
        merchantService.assignedcustomertomerchant(merchant_id,customer_id);
        return ResponseEntity.status(200).body(new ApiResponse("customer assigne to merchant"));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Merchant merchant ){
        merchantService.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted"));
    }


}
