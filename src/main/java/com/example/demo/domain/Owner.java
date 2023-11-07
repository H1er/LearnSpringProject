package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

//lombok annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//spring data jpa annotations
@Entity
@Table(name = "owner") //assigns entity to a table in db
public class Owner {

    @Id //tabla id field
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_id_seq") //gives value automatically
    private Long id;

    private String name;
    private Long age;
    private String address;
}
