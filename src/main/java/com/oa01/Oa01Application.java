package com.oa01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.oa01.mapper")
@ServletComponentScan
public class Oa01Application {

    public static void main(String[] args) {
        SpringApplication.run(Oa01Application.class, args);
    }

}
