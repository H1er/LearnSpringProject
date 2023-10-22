package com.example.demo.dao.impl;

import com.example.demo.TestDataUtil;
import com.example.demo.domain.Owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
         Owner owner = TestDataUtil.getTestOwner();

         subject.create(owner);

         verify(jdbcTemplate).update(
                 "INSERT INTO owner (id,name,age,address) VALUES (?,?,?,?)",
                 1L,"James",24L,"C/street, 24"
                 );
     }

    @Test
    public  void testReadOneCorrectSQL()
    {
        subject.findOne(1L);

        verify(jdbcTemplate).query(eq("SELECT id,name,age,address FROM owner WHERE id=? LIMIT 1"),
                ArgumentMatchers.<OwnerDAOImpl.OwnerRowMapper>any(),
                eq(1L)
        );
    }
}
