package com.example.demo.dao.impl;

import com.example.demo.TestDataUtil;
import com.example.demo.dao.OwnerDAO;
import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //hace que se limpie el contexto después
public class AnimalDAOmplIntegrationTests {                                 // de cada test. De esta manera, información introducida
                                                                            // en bdd en un test no afectará al siguiente
    private OwnerDAO owner;
    private AnimalDAOImpl subject;

    @Autowired
    public AnimalDAOmplIntegrationTests(AnimalDAOImpl subject, OwnerDAO owner)
    {
        this.subject=subject;
        this.owner=owner;
    }

    @Test
    public void testAnimalCreatedAndFound()
    {
        Owner owner = TestDataUtil.getTestOwnerA();
        Animal animal = TestDataUtil.getTestAnimalA();
        animal.setOwner_id(owner.getId());
        this.owner.create(owner);

        subject.create(animal);
        Optional<Animal> result = subject.findOne(animal.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(animal);
    }

    @Test
    public void testMultiplieAnimalsCreatedAndFound()
    {
        Owner o1 = TestDataUtil.getTestOwnerA();
        Owner o2 = TestDataUtil.getTestOwnerB();
        owner.create(o1);
        owner.create(o2);

        List<Animal> animals;
        Animal animalA = TestDataUtil.getTestAnimalA();
        Animal animalB = TestDataUtil.getTestAnimalB();
        Animal animalC = TestDataUtil.getTestAnimalC();
        subject.create(animalA);
        subject.create(animalB);
        subject.create(animalC);

        animals=subject.getAll();

        assertThat(animals).hasSize(3)
                .contains(animalA,animalB,animalC);
    }

}
