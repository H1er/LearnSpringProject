package com.example.demo.dao;

import com.example.demo.dao.impl.AnimalDAOImpl;
import com.example.demo.domain.Animal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AnimalDAOImplTests {
    @Mock //indica que se usara como mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks //indica que se haga la inyeccion de dependencias con el/los mock/s
    private AnimalDAOImpl subject;

    @Test
    public void testCreateAnimalCorrectSQL()
    {
        Animal animal = Animal.builder() // Esta forma de crear objetos es posible gracias a que la clase utiliza
                .id(1L)                  // el patron de diseño builder, especificado por la etiqueta @Builder de lombok
                .age(4L)
                .name("cosa")
                .race("raza")
                .owner_id(1L)
                .build();

        subject.create(animal);
        verify(jdbcTemplate).update("INSERT INTO animal (id,age,name,race,owner_id) VALUES (?,?,?,?,?)",
                                    1L,4L,"cosa","raza",1L);
    }

}
