package com.example.demo.dao;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;

import java.util.Optional;

public interface OwnerDAO {
    public void create(Owner owner);

    public Optional<Owner> findOne(long ownerId);
}
