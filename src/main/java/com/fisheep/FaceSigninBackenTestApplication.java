package com.fisheep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//排除自动装配的数据源
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FaceSigninBackenTestApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FaceSigninBackenTestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FaceSigninBackenTestApplication.class, args);
    }

}
