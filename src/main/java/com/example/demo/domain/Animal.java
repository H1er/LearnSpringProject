package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_id_seq")
    private Long id;

    private Long age;
    private String name;
    private String race;

    @ManyToOne(cascade = CascadeType.ALL) //all changes made to the owner from here will be stored in db
    @JoinColumn(name = "owner_id") //name of the column used in db to reference
    private Owner owner;
}
