package com.zhixi.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.zhixi.annotation.JsonDesensitization;
import com.zhixi.desensitizer.Desensitizer;
import com.zhixi.enums.DesensitizationType;

import java.io.IOException;
import java.util.Objects;

/**
 * auto：zhixi
 * 序列化
 */
public class JsonDesensitizationSerializer extends JsonSerializer<String> implements ContextualSerializer {


    private DesensitizationType type;

    public JsonDesensitizationSerializer() {
    }

    public JsonDesensitizationSerializer(DesensitizationType type) {
        this.type = type;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty property) throws JsonMappingException {
        if (property != null) {
            // 判断是不是String类型的参数
            if (Objects.equals(property.getType().getRawClass(), String.class)) {
                // 获取属性上面的注解
                JsonDesensitization annotation = property.getAnnotation(JsonDesensitization.class);
                if (annotation == null) {
                    annotation = property.getContextAnnotation(JsonDesensitization.class);
                }
                if (annotation != null) {
                    // 给当前属性赋值
                    return new JsonDesensitizationSerializer(annotation.value());
                }
            }
            return serializerProvider.findValueSerializer(property.getType(), property);
        } else {
            return serializerProvider.findNullValueSerializer(null);
        }
    }


    /**
     * 重写序列化方法 容器中所有调用统一生效
     */
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Desensitizer desensitizer = DesensitizerFactory.get(this.type);
        jsonGenerator.writeString(desensitizer.desensitize(s));
    }
}
