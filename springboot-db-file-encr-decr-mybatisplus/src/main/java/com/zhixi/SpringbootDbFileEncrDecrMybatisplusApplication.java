package com.zhixi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author zhixi
 */
@MapperScan("com.zhixi.mapper")
@SpringBootApplication
public class SpringbootDbFileEncrDecrMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDbFileEncrDecrMybatisplusApplication.class, args);
    }

}
