package com.csj.framework.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MallApiApplication_War extends SpringBootServletInitializer  {

    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication_War.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MallApiApplication_War.class);
    }

}
