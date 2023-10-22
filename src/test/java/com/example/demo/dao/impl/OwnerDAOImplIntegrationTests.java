package com.example.demo.dao.impl;

import com.example.demo.TestDataUtil;
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
public class OwnerDAOImplIntegrationTests {
    OwnerDAOImpl subject;

    @Autowired   //al ser un test, tenemos que usar la anotacion para indicar que queremos que se inyecte
    public OwnerDAOImplIntegrationTests( OwnerDAOImpl subject) {
        this.subject=subject;
    }

    @Test //crea un owner en la bdd y comprueba que este está presente en la base de datos
    public void testOwnerCreatedAndFound()
    {
        Owner owner = TestDataUtil.getTestOwner();
        subject.create(owner);
        Optional<Owner> result = subject.findOne(owner.getId());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(owner);

    }
}
