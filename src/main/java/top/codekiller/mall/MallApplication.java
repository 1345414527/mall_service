package top.codekiller.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@Configuration
public class MallApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //file:D:/workspace/mall/src/main/resources/img/
        registry.addResourceHandler("/static/**","/img/**","/templates/**").
                addResourceLocations("file:D:/workspace/mall/src/main/resources/img/");
    }

}
