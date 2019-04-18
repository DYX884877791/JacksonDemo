package com.dyx.test;

import com.dyx.pojo.User;
import com.dyx.util.JsonUtils;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JsonToPojo {

    private ObjectMapper mapper = null;

    @Before
    public void init() {
        mapper = new ObjectMapper();
    }

    //json数据转换成java对象
    @Test
    public void jsonToPojo() throws Exception {
        String json = "{\"name\":\"严狗\",\"age\":22,\"birthday\":20180212121212,\"email\":null}";
        User user = (User) mapper.readValue(json, User.class);
        System.out.println(user);
    }

    //json数据转换成list对象
    @Test
    public void jsonToList() throws Exception {
        String json = "[{\"name\":\"严狗\",\"age\":22,\"birthday\":847296000000,\"email\":null},"
                + "{\"name\":\"陈立其\",\"age\":22,\"birthday\":847468800000,\"email\":null}]";
        //JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> users = mapper.readValue(json, javaType);
        for (User user : users) {
            System.out.println(user);
        }
        //mapper.readValue(src, valueType)
    }

    //=================使用工具类
    @Test
    public void jsonToPojo1() throws Exception {
        String json = "{\"name\":\"严狗\",\"age\":22,\"birthday\":847296000000,\"email\":null}";
        User user = JsonUtils.jsonToPojo(json, User.class);
        System.out.println(user);
    }


    @Test
    public void jsonToList1() throws Exception {
        String json = "[{\"name\":\"严狗\",\"age\":22,\"birthday\":847296000000,\"email\":null},"
                + "{\"name\":\"陈立其\",\"age\":22,\"birthday\":847468800000,\"email\":null}]";

        List<User> users = JsonUtils.jsonToList(json, User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
