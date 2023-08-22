package com.example.week5relations.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition="varchar(20) not null")
    private String name;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
    private Set<Branche> branchesset;

    @ManyToMany(mappedBy = "merchantSet")
    private  Set<Customer> customerset;
}
