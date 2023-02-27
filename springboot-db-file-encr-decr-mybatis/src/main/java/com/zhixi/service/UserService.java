package com.zhixi.service;

import com.zhixi.pojo.User;

/**
* @author zhangzhixi
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-01 12:15:07
*/
public interface UserService {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    User selectByIdUser(Long id);
    int insertUser(User user);
}
