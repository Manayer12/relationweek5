package com.example.week5relations.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Set;

//replace dat with getter and setter to avoid any problems with relations
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

@Column(columnDefinition="varchar(20) not null")
    private String name;


//"customer" must be the same object in the customerdetails class
//relation
//cascade when this delete ,delete detail
@OneToOne(cascade =CascadeType.ALL,mappedBy = "customer")
@PrimaryKeyJoinColumn
//connct the keys to gather
CustomerDetails customerDetails;

@ManyToMany
@JsonIgnore
private Set<Merchant> merchantSet;
}
