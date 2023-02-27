package com.zhixi.mapper;

import com.zhixi.pojo.User;
import org.springframework.stereotype.Repository;

/**
* @author zhangzhixi
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-01 12:15:07
* @Entity com.zhixi.pojo.User
*/
@Repository
public interface UserMapper {

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    User selectByIdUser(Long id);

    /**
     * 插入数据
     *
     * @param user 用户实体
     * @return 成功返回用户ID、失败返回提示信息
     */
    int insertUser(User user);
}




