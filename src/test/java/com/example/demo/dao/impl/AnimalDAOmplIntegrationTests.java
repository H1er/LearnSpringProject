package com.example.demo.dao.impl;

import com.example.demo.TestDataUtil;
import com.example.demo.dao.OwnerDAO;
import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AnimalDAOmplIntegrationTests {

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
        Owner owner = TestDataUtil.getTestOwner();
        Animal animal = TestDataUtil.getTestAnimal();
        animal.setOwner_id(owner.getId());
        this.owner.create(owner);

        subject.create(animal);
        Optional<Animal> result = subject.findOne(animal.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(animal);

    }

}
