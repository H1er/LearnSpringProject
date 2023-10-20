package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
    private Long id;
    private Long age;
    private String name;
    private String race;
    private Long owner_id;
}
