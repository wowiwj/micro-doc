package wangju.microdoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@MapperScan(
    basePackages = "wangju.microdoc.*",
    annotationClass = Repository.class
)
// h2 数据库测试解决方案 https://stackoverflow.com/questions/47895212/spring-boot-2-h2-database-springboottest-failing-on-org-h2-jdbc-jdbcsqlex
@AutoConfigureTestDatabase
public class MicroDocApplicationTests {

    @Test
    public void contextLoads() {
    }

}

