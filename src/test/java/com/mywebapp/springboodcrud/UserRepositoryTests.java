package com.mywebapp.springboodcrud;

import com.mywebapp.springboodcrud.user.User;
import com.mywebapp.springboodcrud.user.UserReporsitory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserReporsitory repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("shirashshrestha10@gmail.com");
        user.setPassword("12345");
        user.setFirstName("Sirash");
        user.setLastName("Shrestha");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

}
