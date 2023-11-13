package com.example.demo.repositories;

import com.example.demo.domain.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //similar to @Component anotation
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    Iterable<Owner> ageLessThan(int age); //crud repository has all crud methods implemented by default

    @Query("select o from Owner o where o.age> ?1") //HQL, el use de '?' es para indicar parametros, en este caso, ?1 hace referencia al primer parametro de la funcion
    Iterable<Owner> findOwnerWithAgeGreaterThan(int age);
}
