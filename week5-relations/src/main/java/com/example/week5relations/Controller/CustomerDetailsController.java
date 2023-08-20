package com.example.week5relations.Controller;

import com.example.week5relations.Api.ApiResponse;
import com.example.week5relations.DTO.CustomerDTO;
import com.example.week5relations.Model.Customer;
import com.example.week5relations.Service.CustomerService;
import com.example.week5relations.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/details")
public class CustomerDetailsController {
    private final DetailsService detailsService;
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CustomerDTO customerDTO){
        detailsService.adddetails(customerDTO);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(detailsService.getAll());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable  Integer id,@RequestBody @Valid CustomerDTO customerDTO){
        detailsService.updateDetails(id,customerDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Detail Deleted"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        detailsService.deleteDetails( id);
        return ResponseEntity.status(200).body(new ApiResponse("Detail deleted"));
    }


}
