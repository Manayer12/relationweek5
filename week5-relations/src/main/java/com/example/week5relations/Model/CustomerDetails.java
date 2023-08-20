package com.example.week5relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
    //you don't have to make it generatedvalue cause it wil connected automatically in one to one relation with customer
    @Id
    private Integer id;

    private String gender;

    private Integer age;

    private String email;


    @OneToOne
    @MapsId
    @JsonIgnore
    Customer customer;

}
