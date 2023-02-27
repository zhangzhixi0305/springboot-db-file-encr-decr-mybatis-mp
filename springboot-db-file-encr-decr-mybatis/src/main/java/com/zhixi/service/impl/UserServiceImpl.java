package com.zhixi.service.impl;

import com.zhixi.mapper.UserMapper;
import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangzhixi
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-05-01 12:15:07
 */
@Service
public class UserServiceImpl  implements UserService {
    /**
     * 日志
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 根据ID查询用户
     * 这里的@Cacheable注解不需要添加key属性了，因为已经在全局制定过了key的生成策略
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User selectByIdUser(Long id) {
        LOGGER.info("根据ID查询用户-查询数据库");
        return userMapper.selectByIdUser(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}




