package com.zhixi.pojo;

import cn.zhz.privacy.annotation.FieldDesensitize;
import cn.zhz.privacy.annotation.FieldEncrypt;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @FieldEncrypt
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    @FieldDesensitize(fillValue = "*")
    private String email;

    /**
     * 地址
     */
    @FieldEncrypt
    private String address;

    /**
     * 版本号，用于乐观锁
     */
    private Integer version;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    // 对入参进行格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 对出参进行格式化
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 删除状态，0表示未删除，1表示已删除
     */
    private Integer deleted;

    /**
     * 创建时间，使用MyBatis Plus自动填充功能
     */
    private String createAt;

    /**
     * 更新时间，使用MyBatis Plus自动填充功能
     */
    private String updateAt;

    private static final long serialVersionUID = 1L;
}