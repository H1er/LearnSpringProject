//package olds.dao.impl;
//
//import olds.dao.AnimalDAO;
//import com.example.demo.domain.Animal;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class AnimalDAOImpl implements AnimalDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    public AnimalDAOImpl(JdbcTemplate jdbcTemplate)
//    {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void create(Animal animal)
//    {
//        jdbcTemplate.update("INSERT INTO animal (id,age,name,race,owner_id) VALUES (?,?,?,?,?)",
//                            animal.getId(), animal.getAge(),animal.getName(),animal.getRace(),animal.getOwner_id());
//        /* El tema de los '?' es una consulta parametrizada, se indica con el '?' donde va un valor, y luego se
//        *  especifican los valores en orden (es como los printf de C) */
//    }
//
//    public Optional<Animal> findOne(long animalId)
//    {
//        List<Animal> results = jdbcTemplate.query("SELECT id,age,name,race,owner_id FROM animal WHERE id=? LIMIT 1",
//                                                        new AnimalRowMapper(),animalId);
//
//        return results.stream().findFirst();
//    }
//
//    public List<Animal> getAll()
//    {
//        return jdbcTemplate.query("SELECT id,age,name,race,owner_id FROM animal",
//                                        new AnimalRowMapper());
//    }
//
//    public void update(Animal animal)
//    {
//        jdbcTemplate.update("UPDATE animal SET age=?, name=?, race=?, owner_id=? WHERE id=?",
//                                animal.getAge(),
//                                animal.getName(),
//                                animal.getRace(),
//                                animal.getOwner_id(),
//                                animal.getId());
//
//    }
//
//    public void delete(Long  animalId)
//    {
//        jdbcTemplate.update("DELETE FROM animal WHERE id=?",animalId);
//    }
//
//    public static class AnimalRowMapper implements RowMapper<Animal>{
//
//        @Override
//        public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return Animal.builder()
//                    .id(rs.getLong("id"))
//                    .name(rs.getString("name"))
//                    .age(rs.getLong("age"))
//                    .race(rs.getString("race"))
//                    .owner_id(rs.getLong("owner_id"))
//                    .build();
//        }
//    }
//
//}
