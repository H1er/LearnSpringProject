package com.example.demo;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Owner getTestOwnerA()
    {
        return Owner.builder()
            .id(1L)
            .name("James")
            .age(24L)
            .address("C/street, 24")
            .build();
    }

    public static Owner getTestOwnerB()
    {
        return Owner.builder()
                .id(2L)
                .name("Anthony")
                .age(34L)
                .address("C/street, 25")
                .build();
    }

    public static Owner getTestOwnerC()
    {
        return Owner.builder()
                .id(3L)
                .name("Stephen")
                .age(44L)
                .address("C/street, 26")
                .build();
    }

    public static Animal getTestAnimalA()
    {
        return Animal.builder() // Esta forma de crear objetos es posible gracias a que la clase utiliza
                .id(1L)                  // el patron de diseño builder, especificado por la etiqueta @Builder de lombok
                .age(4L)
                .name("cosa")
                .race("raza")
                .owner_id(1L)
                .build();
    }

    public static Animal getTestAnimalB()
    {
        return Animal.builder()
                .id(2L)
                .age(7L)
                .name("thing")
                .race("cool")
                .owner_id(2L)
                .build();
    }

    public static Animal getTestAnimalC()
    {
        return Animal.builder()
                .id(3L)
                .age(7L)
                .name("chose")
                .race("arigato")
                .owner_id(1L)
                .build();
    }
}
