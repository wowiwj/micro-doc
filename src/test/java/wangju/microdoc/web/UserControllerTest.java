package wangju.microdoc.web;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Log
@AutoConfigureTestDatabase
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void all() throws Exception {

        MvcResult result;
        result = mvc.perform(
                MockMvcRequestBuilders.get("/users")
                        .param("page", "1")
                        .param("limit", "20")
        ).andReturn();

        assertEquals(200,result.getResponse().getStatus());
        log.info(result.getResponse().getContentAsString());
    }
}