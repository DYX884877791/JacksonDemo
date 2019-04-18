package com.dyx.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期序列化类
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    /**
     * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
     *      com.fasterxml.jackson.core.JsonGenerator,
     *      com.fasterxml.jackson.databind.SerializerProvider)
     */
    @Override
    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        om.writeValue(generator, sdf.format(date));
    }
}
