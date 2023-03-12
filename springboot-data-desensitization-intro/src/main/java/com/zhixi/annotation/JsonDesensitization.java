package com.zhixi.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zhixi.enums.DesensitizationType;
import com.zhixi.support.JsonDesensitizationSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author zhixi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@JacksonAnnotationsInside
@JsonSerialize(using = JsonDesensitizationSerializer.class)
public @interface JsonDesensitization {
    /**
     * 脱敏的类型：比如手机号、邮箱
     *
     * @return 脱敏类型
     */
    DesensitizationType value();
}
