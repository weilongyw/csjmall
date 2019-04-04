package com.csj.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MallBuyerApplication_War extends SpringBootServletInitializer  {

    public static void main(String[] args) {
        SpringApplication.run(MallBuyerApplication_War.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MallBuyerApplication_War.class);
    }

}
