package wangju.microdoc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(
    basePackages = "wangju.microdoc.*",
    annotationClass = Repository.class
)
public class MicroDocApplicationTests {

    @Test
    public void contextLoads() {
    }

}

