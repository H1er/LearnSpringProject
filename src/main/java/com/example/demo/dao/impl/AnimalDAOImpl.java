package com.example.demo.dao.impl;

import com.example.demo.dao.AnimalDAO;
import com.example.demo.domain.Animal;
import org.springframework.jdbc.core.JdbcTemplate;

public class AnimalDAOImpl implements AnimalDAO {
    private final JdbcTemplate jdbcTemplate;

    public AnimalDAOImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Animal animal)
    {
        jdbcTemplate.update("INSERT INTO animal (id,age,name,race,owner_id) VALUES (?,?,?,?,?)",
                            animal.getId(), animal.getAge(),animal.getName(),animal.getRace(),animal.getOwner_id());
        /* El tema de los '?' es una consulta parametrizada, se indica con el '?' donde va un valor, y luego se
        *  especifican los valores en orden (es como los printf de C) */
    }

}
