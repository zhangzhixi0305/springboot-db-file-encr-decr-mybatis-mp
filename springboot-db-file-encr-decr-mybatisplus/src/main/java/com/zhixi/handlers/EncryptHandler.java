package com.zhixi.handlers;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * @Description
 * @Author Huicong She
 * @Date 2022/8/5 11:36
 *
 */

/**
 * @ClassName EncryptHandler
 * @Author zhangzhixi
 * @Description 数据库字段加解密handler,JdbcType.VARCHAR：表示该处理器处理的数据类型
 * @Date 2023-02-26 20:01
 * @Version 1.0
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class EncryptHandler extends BaseTypeHandler<String> {
    /**
     * 线上运行后勿修改，会影响已加密数据解密
     */
    private static final byte[] KEYS = "shc987654321camp".getBytes(StandardCharsets.UTF_8);
 
    /**
     * 设置参数
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if (StringUtils.isEmpty(parameter)) {
            ps.setString(i, null);
            return;
        }
        AES aes = SecureUtil.aes(KEYS);
        String encrypt = aes.encryptHex(parameter);
        ps.setString(i, encrypt);
    }
 
    /**
     * 获取值
     */
    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return decrypt(rs.getString(columnName));
    }
 
    /**
     * 获取值
     */
    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return decrypt(rs.getString(columnIndex));
    }
 
    /**
     * 获取值
     */
    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decrypt(cs.getString(columnIndex));
    }
 
    public String decrypt(String value) {
        if (null == value) {
            return null;
        }
        return SecureUtil.aes(KEYS).decryptStr(value);
    }
}