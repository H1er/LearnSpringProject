package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    @Id //tabla id field
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_id_seq") //gives value automatically
    private Long id;

    private String name;
    private Long age;

    @JsonProperty("dir")  //hace que al crear el JSON de un objeto, la clave tenga el nombre indicado en vez del de la variable
    private String address;
}
