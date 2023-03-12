package com.zhixi.desensitizer;


/**
 * @author zhixi
 *
 */
public interface Desensitizer {
    /**
     * 对数据进行脱敏
     * @param origin 脱敏数据
     * @return 脱敏后的数据
     */
    String desensitize(String origin);
}
