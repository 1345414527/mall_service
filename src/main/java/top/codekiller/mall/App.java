package top.codekiller.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author codekiller
 * @date 2021/7/11 11:18
 * @Description TODO
 */
@Configuration
@SpringBootApplication
@MapperScan("top.codekiller.mall.mapper")
public class App implements WebMvcConfigurer {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  后台启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //file:D:/workspace/mall/src/main/resources/img/
        registry.addResourceHandler("/static/**","/img/**","/templates/**").
                addResourceLocations("file:D:/workspace/mall/src/main/resources/img/");
    }

}

