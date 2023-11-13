package com.example.demo.repositories;

import com.example.demo.TestDataUtil;
import com.example.demo.domain.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OwnerRepositoryIntegrationTests {
    OwnerRepository subject;

    @Autowired   //al ser un test, tenemos que usar la anotacion para indicar que queremos que se inyecte
    public OwnerRepositoryIntegrationTests(OwnerRepository subject) {
        this.subject=subject;
    }

    @Test //crea un owner en la bdd y comprueba que este está presente en la base de datos
    public void testOwnerCreatedAndFound()
    {
        Owner owner = TestDataUtil.getTestOwnerA();
        subject.save(owner);
        Optional<Owner> result = subject.findById(owner.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(owner);
    }

    @Test
    public void testMultipleOwnersCreatedAndFound()
    {
        Iterable<Owner> owners;
        Owner ownerA = TestDataUtil.getTestOwnerA();
        Owner ownerB = TestDataUtil.getTestOwnerB();
        Owner ownerC = TestDataUtil.getTestOwnerC();
        subject.save(ownerA);
        subject.save(ownerB);
        subject.save(ownerC);

        owners = subject.findAll();
        assertThat(owners)
                .hasSize(3)
                .contains(ownerA,ownerB,ownerC);


    }

    @Test
    public void testOwnerIsCreatedAndModified()
    {
        Owner owner = TestDataUtil.getTestOwnerA();
        Long owner_age_prev = owner.getAge();
        String owner_name_prev = owner.getName();

        subject.save(owner);
        owner.setAge((owner_age_prev+10L));
        owner.setName(owner_name_prev+" test");

        subject.save(owner);
        Optional<Owner> testowner = subject.findById(owner.getId());

        assertThat(testowner.isPresent());
        assertThat(testowner.get().getAge()).isEqualTo(owner_age_prev+10L);
        assertThat(testowner.get().getName()).isEqualTo(owner_name_prev+" test");
    }

    @Test
    public void testOwnerIsCreatedAndDeleted()
    {
        Owner owner=TestDataUtil.getTestOwnerA();
        subject.save(owner);
        subject.deleteById(owner.getId());
        Optional<Owner> oowner = subject.findById(owner.getId());

        assertThat(!oowner.isPresent());
    }

    @Test
    public void testGetOwnerAgeLessThan() //el metodo como tal no esta implementado, pero partiendo del nombre, spring data jpa
    {                                     //es capaz de deducir que deberia de hacer el metodo
        Owner ownerA = TestDataUtil.getTestOwnerA();
        Owner ownerB = TestDataUtil.getTestOwnerB();
        Owner ownerC = TestDataUtil.getTestOwnerC();
        subject.save(ownerA);
        subject.save(ownerB);
        subject.save(ownerC);

        Iterable<Owner> results = subject.ageLessThan(40);
        assertThat(results).containsExactly(ownerA,ownerB);


    }
}
