package wangju.microdoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan(
    basePackages = "wangju.microdoc.*",
    annotationClass = Repository.class
)
public class MicroDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroDocApplication.class, args);
    }

}

