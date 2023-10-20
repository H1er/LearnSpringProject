package com.example.demo.dao;

import com.example.demo.domain.Animal;

import java.util.Optional;

public interface AnimalDAO {

    public void create(Animal animal);

    public Optional<Animal> findOne(long animalId);
}
