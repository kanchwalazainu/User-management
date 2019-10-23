package com.user;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.model.User;
import com.user.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindById() {
        entityManager.persist(new User("Firstname","Lastname","firstname@test.com"));
        List<User> users= new ArrayList<User>();
        userRepository.findAll().forEach(users::add);
        assertEquals("Firstname", users.get(0).getFirstName());
        assertEquals("Lastname", users.get(0).getLastName());
        assertEquals("firstname@test.com", users.get(0).getEmailId());
        assertEquals(false, users.get(0).isDeletedFlag());
   }

}
