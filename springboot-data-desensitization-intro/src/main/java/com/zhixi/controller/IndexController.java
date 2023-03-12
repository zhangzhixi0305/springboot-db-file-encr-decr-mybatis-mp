package com.zhixi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhixi.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://www.altitude.xin" target="_blank">Java知识图谱</a>
 * @author <a href="https://gitee.com/decsa/ucode-cms-vue" target="_blank">UCode CMS</a>
 * @author <a href="https://space.bilibili.com/1936685014" target="_blank">B站视频</a>
 **/
@RestController
public class IndexController {
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 创建用户对象 模拟从数据库中取值
     */
    private User createUser() {
        return new User(110L, "admin", "18326313814", "136148@qq.com");
    }


    /**
     * 脱敏数据
     */
    @GetMapping("/test1")
    public ResponseEntity<User> test1() {
        User user = createUser();
        return ResponseEntity.ok(user);
    }
}
