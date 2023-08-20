package com.example.week5relations.DTO;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Valid
public class CustomerDTO {

    private Integer customer_id;
    private String gender;

    private Integer age;

    private String email;
}
