//package olds;
//
//import com.example.demo.TestDataUtil;
//import com.example.demo.domain.Owner;
//
//import olds.dao.impl.OwnerDAOImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//
//@ExtendWith(MockitoExtension.class)
//public class OwnerDAOImplTests {
//     @Mock
//     private JdbcTemplate jdbcTemplate;
//
//     @InjectMocks
//     private OwnerDAOImpl subject;
//
//     @Test
//     public void testCreateOwnerCorrectSQL(){
//         Owner owner = TestDataUtil.getTestOwnerA();
//
//         subject.create(owner);
//
//         verify(jdbcTemplate).update(
//                 "INSERT INTO owner (id,name,age,address) VALUES (?,?,?,?)",
//                 1L,"James",24L,"C/street, 24"
//                 );
//     }
//
//    @Test
//    public  void testReadOneCorrectSQL()
//    {
//        subject.findOne(1L);
//
//        verify(jdbcTemplate).query(eq("SELECT id,name,age,address FROM owner WHERE id=? LIMIT 1"),
//                ArgumentMatchers.<OwnerDAOImpl.OwnerRowMapper>any(),
//                eq(1L)
//        );
//    }
//
//    @Test
//    public void testGetAllCorrectSQL()
//    {
//        subject.getAll();
//        verify(jdbcTemplate).query(eq("SELECT id,name,age,address FROM owner"),
//                ArgumentMatchers.<OwnerDAOImpl.OwnerRowMapper>any());
//    }
//
//    @Test
//    public void testUpdateCorrectSQL()
//    {
//        Owner owner = TestDataUtil.getTestOwnerA();
//        subject.update(owner);
//
//        verify(jdbcTemplate).update(eq("UPDATE owner SET name=?, age=?, address=? where id=?"),
//                        eq(owner.getName()),
//                        eq(owner.getAge()),
//                        eq(owner.getAddress()),
//                        eq(owner.getId())
//                );
//    }
//
//    @Test
//    public void testDeleteCorrectSQL()
//    {
//        Owner owner = TestDataUtil.getTestOwnerA();
//        subject.delete(owner.getId());
//
//        verify(jdbcTemplate).update("DELETE FROM owner WHERE id=?",owner.getId());
//
//    }
//}
