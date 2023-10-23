package com.example.demo.dao;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerDAO {
    //CRUD operations
    //C
    public void create(Owner owner);
    //R
    public Optional<Owner> findOne(long ownerId);
    //R
    public List<Owner> getAll();
    //U
    public void update(Owner owner);
    //D
    public void delete(Long id);
}
