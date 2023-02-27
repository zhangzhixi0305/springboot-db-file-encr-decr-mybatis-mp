package com.zhixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zhixi.mapper")
@SpringBootApplication
public class SpringbootDbFileEncrDecrMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDbFileEncrDecrMybatisApplication.class, args);
    }

}
