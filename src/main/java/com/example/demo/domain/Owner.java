package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    private Long id;
    private String name;
    private Long age;
    private String address;
}
