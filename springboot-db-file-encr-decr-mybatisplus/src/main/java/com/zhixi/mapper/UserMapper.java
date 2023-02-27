package com.zhixi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixi.pojo.User;
import org.springframework.stereotype.Repository;

/**
* @author zhangzhixi
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-01 12:15:07
* @Entity com.zhixi.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {
}




