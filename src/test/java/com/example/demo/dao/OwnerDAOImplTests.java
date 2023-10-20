package com.example.demo.dao;

import com.example.demo.dao.impl.OwnerDAOImpl;
import com.example.demo.domain.Owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class OwnerDAOImplTests {
     @Mock
     private JdbcTemplate jdbcTemplate;

     @InjectMocks
     private OwnerDAOImpl subject;

     @Test
     public void testCreateOwnerCorrectSQL(){
         Owner owner = Owner.builder()
                 .id(1L)
                 .name("James")
                 .age(24L)
                 .address("C/street, 24")
                 .build();

         subject.create(owner);

         verify(jdbcTemplate).update(
                 "INSERT INTO owner (id,name,age,address) VALUES (?,?,?,?)",
                 1L,"James",24L,"C/street, 24"
                 );
     }
}
