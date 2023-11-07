package com.example.demo.repositories;

import com.example.demo.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //similar to @Component anotation
public interface OwnerRepository extends CrudRepository<Owner,Long> { //crud repository has all crud methods implemented by default
}
