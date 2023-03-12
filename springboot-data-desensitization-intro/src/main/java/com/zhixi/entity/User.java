package com.zhixi.entity;

import com.zhixi.annotation.JsonDesensitization;
import com.zhixi.enums.DesensitizationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String userName;
    
    /**
     * 手机号
     */
    @JsonDesensitization(DesensitizationType.MOBILE)
    private String phone;
    /**
     * 邮箱
     */
    @JsonDesensitization(DesensitizationType.EMAIL)
    private String email;
    
}
