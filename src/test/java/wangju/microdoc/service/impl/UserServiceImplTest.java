package wangju.microdoc.service.impl;

import com.github.pagehelper.Page;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import wangju.microdoc.model.domain.User;

import static org.junit.Assert.*;

@Log
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void page() {
        Page<User> users = userService.page(1,1);
        log.info(users.toString());
        assertEquals(users.getTotal(),2);
        assertEquals(users.getPages(),2);
    }
}