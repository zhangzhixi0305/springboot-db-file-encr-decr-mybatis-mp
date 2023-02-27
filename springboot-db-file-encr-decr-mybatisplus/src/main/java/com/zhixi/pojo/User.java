package com.zhixi.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.zhixi.handlers.EncryptHandler;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName user
 */
@TableName(value = "user", autoResultMap = true)
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 住址
     */
    @TableField(value = "address", typeHandler = EncryptHandler.class)
    private String address;

    /**
     * 版本号，用于乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
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
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 删除状态，0表示未删除，1表示已删除
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 创建时间，使用MyBatis Plus自动填充功能
     */
    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private String createAt;

    /**
     * 更新时间，使用MyBatis Plus自动填充功能
     */
    @TableField(value = "update_at", fill = FieldFill.UPDATE)
    private String updateAt;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}