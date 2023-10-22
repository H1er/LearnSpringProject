package com.example.demo;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Owner getTestOwner()
    {
        return Owner.builder()
            .id(7L)
            .name("James")
            .age(24L)
            .address("C/street, 24")
            .build();
    }

    public static Animal getTestAnimal()
    {
        return Animal.builder() // Esta forma de crear objetos es posible gracias a que la clase utiliza
                .id(1L)                  // el patron de diseño builder, especificado por la etiqueta @Builder de lombok
                .age(4L)
                .name("cosa")
                .race("raza")
                .owner_id(1L)
                .build();
    }
}
