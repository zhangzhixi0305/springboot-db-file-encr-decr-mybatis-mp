package com.zhixi.support;

import com.zhixi.desensitizer.Desensitizer;
import com.zhixi.desensitizer.impl.DefaultDesensitizer;
import com.zhixi.desensitizer.impl.EmailDesensitizer;
import com.zhixi.desensitizer.impl.MobileDesensitizer;
import com.zhixi.enums.DesensitizationType;
import com.zhixi.desensitizer.Desensitizer;
import com.zhixi.desensitizer.impl.DefaultDesensitizer;
import com.zhixi.desensitizer.impl.EmailDesensitizer;
import com.zhixi.desensitizer.impl.MobileDesensitizer;
import com.zhixi.enums.DesensitizationType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * @author zhixi
 * 工厂模式，传入指定需要脱敏的实现
 */
public class DesensitizerFactory {
    public static final Map<DesensitizationType, Desensitizer> MAP = new HashMap<>();
    
    static {
        MAP.put(DesensitizationType.EMAIL, new EmailDesensitizer());
        MAP.put(DesensitizationType.MOBILE, new MobileDesensitizer());
        MAP.put(DesensitizationType.DEFAULT, new DefaultDesensitizer());
    }
    
    
    /**
     * 如果没有指定的类型 默认什么都不做 原值返回
     */
    public static Desensitizer get(DesensitizationType type) {
        return Optional.ofNullable(MAP.get(type)).orElse(MAP.get(DesensitizationType.DEFAULT));
    }
}
