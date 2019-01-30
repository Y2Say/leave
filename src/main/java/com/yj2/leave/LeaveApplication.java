package com.yj2.leave;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.yj2.leave.mapper")
@SpringBootApplication
public class LeaveApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LeaveApplication.class, args);
    }

    //打包springboot项目
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}

