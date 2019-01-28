package wangju.microdoc.model.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import wangju.microdoc.enumeration.SexEnum;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUser() {
        User user = userRepository.get(1L);
        assertEquals("dufu",user.getUsername());
        assertEquals("哈哈哈",user.getBio());
        assertEquals(SexEnum.MALE,user.getSex());
    }


    @Test
    public void getUserByUsername() {
        User user = userRepository.getByName("dufu");
        assertEquals("哈哈哈",user.getBio());

    }
}