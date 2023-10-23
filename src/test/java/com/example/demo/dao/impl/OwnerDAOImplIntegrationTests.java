package com.example.demo.dao.impl;

import com.example.demo.TestDataUtil;
import com.example.demo.domain.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OwnerDAOImplIntegrationTests {
    OwnerDAOImpl subject;

    @Autowired   //al ser un test, tenemos que usar la anotacion para indicar que queremos que se inyecte
    public OwnerDAOImplIntegrationTests( OwnerDAOImpl subject) {
        this.subject=subject;
    }

    @Test //crea un owner en la bdd y comprueba que este está presente en la base de datos
    public void testOwnerCreatedAndFound()
    {
        Owner owner = TestDataUtil.getTestOwnerA();
        subject.create(owner);
        Optional<Owner> result = subject.findOne(owner.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(owner);
    }

    @Test
    public void testMultipleOwnersCreatedAndFound()
    {
        List<Owner> owners;
        Owner ownerA = TestDataUtil.getTestOwnerA();
        Owner ownerB = TestDataUtil.getTestOwnerB();
        Owner ownerC = TestDataUtil.getTestOwnerC();
        subject.create(ownerA);
        subject.create(ownerB);
        subject.create(ownerC);

        owners = subject.getAll();
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

        subject.create(owner);
        owner.setAge((owner_age_prev+10L));
        owner.setName(owner_name_prev+" test");

        subject.update(owner);
        Optional<Owner> testowner = subject.findOne(owner.getId());

        assertThat(testowner.isPresent());
        assertThat(testowner.get().getAge()).isEqualTo(owner_age_prev+10L);
        assertThat(testowner.get().getName()).isEqualTo(owner_name_prev+" test");
    }

    @Test
    public void testOwnerIsCreatedAndDeleted()
    {
        Owner owner=TestDataUtil.getTestOwnerA();
        subject.create(owner);
        subject.delete(owner.getId());
        Optional<Owner> oowner = subject.findOne(owner.getId());

        assertThat(!oowner.isPresent());
    }
}
