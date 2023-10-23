package com.example.demo.dao.impl;

import com.example.demo.dao.OwnerDAO;
import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
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

    /* A la hora de hacer queries a bdd, el método query() deolverá una lista de objetos especificados al implementar
     * la interfaz rowMapper (ver cabecera de cada rowmapper) */
    public Optional<Owner> findOne(long ownerId)
    {
        List<Owner> results = jdbcTemplate.query("SELECT id,name,age,address FROM owner WHERE id=? LIMIT 1",
                new OwnerDAOImpl.OwnerRowMapper(),ownerId);

        return results.stream().findFirst();
    }

    public List<Owner> getAll()
    {
        return jdbcTemplate.query("SELECT id,name,age,address FROM owner",
                                            new OwnerRowMapper()) ;
    }

    public void update(Owner owner) {
        jdbcTemplate.update("UPDATE owner SET name=?, age=?, address=? where id=?",
                owner.getName(),
                owner.getAge(),
                owner.getAddress(),
                owner.getId());
    }

    public void delete(Long id)
    {
        jdbcTemplate.update("DELETE FROM owner WHERE id=?",id);
    }

    public static class OwnerRowMapper implements RowMapper<Owner> {

        @Override
        public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Owner.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getLong("age"))
                    .address(rs.getString("address"))
                    .build();
        }
    }
}
