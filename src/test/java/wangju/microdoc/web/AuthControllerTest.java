package wangju.microdoc.web;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Log
public class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestLogin() throws Exception {

        MvcResult mvcResult = mvc.
                perform(MockMvcRequestBuilders
                        .post("/auth/login")
                        .param("username", "dufu")
                        .param("password", "123456")
                )
                .andReturn();

        assertEquals(200,mvcResult.getResponse().getStatus());
        assertNotNull(mvcResult.getResponse().getContentAsString());
        String  content = mvcResult.getResponse().getContentAsString();
        log.info(content);
        JSONObject result = JSONObject.parseObject(content);
        assertNotNull(result.get("token"));
    }
}