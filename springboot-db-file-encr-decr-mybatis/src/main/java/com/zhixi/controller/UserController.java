package com.zhixi.controller;

import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-1 12:15
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;


    /**
     * 通过ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.selectByIdUser(id);
    }

    /**
     * 插入数据
     *
     * @param user 用户实体
     * @return 成功返回用户ID、失败返回提示信息
     */
    @PostMapping("/insertUser")
    public String insertUserToMybatisPlus(@RequestBody User user) {
        return userService.insertUser(user) == 1 ? "插入成功,id是：" + user.getId() : "插入失败";
    }

}



