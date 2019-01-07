package wangju.microdoc.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import wangju.microdoc.enumeration.SexEnum;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUser() {
        User user = userRepository.getUser(1L);
        assertEquals("dufu",user.getUsername());
        assertEquals("哈哈哈",user.getBio());
        assertEquals(SexEnum.MALE,user.getSex());
    }
}