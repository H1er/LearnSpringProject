package com.example.demo.dao.impl;

import com.example.demo.dao.OwnerDAO;
import com.example.demo.domain.Owner;
import org.springframework.jdbc.core.JdbcTemplate;

public class OwnerDAOImpl implements OwnerDAO {
    private final JdbcTemplate jdbcTemplate;

    public OwnerDAOImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate= jdbcTemplate;
    }

    public void create(Owner owner)
    {
        jdbcTemplate.update(
                "INSERT INTO owner (id,name,age,address) VALUES (?,?,?,?)",
                owner.getId(), owner.getName(), owner.getAge(), owner.getAddress());

    }
}
