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
public class Branche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    @Column(columnDefinition="varchar(20) not null")
    private String area;


    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    @JsonIgnore
    private Merchant merchant;
}
