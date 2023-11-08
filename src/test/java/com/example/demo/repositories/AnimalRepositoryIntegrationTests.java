package com.example.demo.repositories;

import com.example.demo.TestDataUtil;

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
public class AnimalRepositoryIntegrationTests {                                 // de cada test. De esta manera, información introducida

    private AnimalRepository subject;

    @Autowired
    public AnimalRepositoryIntegrationTests(AnimalRepository subject)
    {
        this.subject=subject;
    }

    @Test
    public void testAnimalCreatedAndFound()
    {
        Owner owner = TestDataUtil.getTestOwnerA();
        Animal animal = TestDataUtil.getTestAnimalA(owner);

        subject.save(animal);

        Optional<Animal> result = subject.findById(animal.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(animal);
    }

    @Test
    public void testMultipleAnimalsCreatedAndFound()
    {
        Owner o1 = TestDataUtil.getTestOwnerA();
        Owner o2 = TestDataUtil.getTestOwnerB();

        Iterable<Animal> animals;
        Animal animalA = TestDataUtil.getTestAnimalA(o1);
        Animal animalB = TestDataUtil.getTestAnimalB(o1);
        Animal animalC = TestDataUtil.getTestAnimalC(o2);
        subject.save(animalA);
        subject.save(animalB);
        subject.save(animalC);

        animals=subject.findAll();


        assertThat(animals).hasSize(3)
                .contains(animalA,animalB,animalC);
    }

    @Test
    public void testAnimalCreatedAndModified()
    {
        Owner own = TestDataUtil.getTestOwnerA();
        Animal animal = TestDataUtil.getTestAnimalA(own);

        Long age_prev=animal.getAge();


        subject.save(animal);
        animal.setName("testname");
        animal.setAge(age_prev+1L);
        subject.save(animal);
        Optional<Animal> opt = subject.findById(animal.getId());

        assertThat(opt.isPresent());
        assertThat(opt.get().getName()).isEqualTo("testname");
        assertThat(opt.get().getAge()).isEqualTo((age_prev+1L));
    }

    @Test
    public void testAnimalCreatedAndDeleted()
    {
        Owner own= TestDataUtil.getTestOwnerA();
        Animal animal = TestDataUtil.getTestAnimalA(own);

        subject.save(animal);

        subject.deleteById(animal.getId());

        Optional<Animal> opt = subject.findById(animal.getId());

        assertThat(!opt.isPresent());

    }

}
