package wangju.microdoc.service.impl;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wangju.microdoc.domain.User;

import static org.junit.Assert.*;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceImplTest {

    @Autowired
    private TokenServiceImpl tokenService;

    @Before
    public void setUp() throws Exception {
        log.info("Before >>");
    }

    @After
    public void tearDown() throws Exception {
        log.info("<< Done");
    }

    @Test
    public void getToken() {

        User user = new User();
        user.setId(1L);
        user.setPassword("123456");
        String token = tokenService.getToken(user);
        assertTrue(token.length() > 0);
    }
}