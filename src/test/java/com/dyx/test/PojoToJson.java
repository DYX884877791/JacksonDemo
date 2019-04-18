package com.dyx.test;

import com.dyx.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PojoToJson {
    private ObjectMapper mapper = null;

    @Before
    public void init() {
        mapper = new ObjectMapper();
    }

    //对象转化成json
    @Test
    public void ObjectToJson() throws Exception {
        User user = new User();
        user.setName("严狗");
        user.setAge(22);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateFormat.parse("1996-11-07"));

        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(user);
        System.out.println(jsonUser);
    }

    //将list对象转换成json
    @Test
    public void listToJson() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setName("严狗");
        user.setAge(22);
        user.setBirthday(new Date());
        User user1 = new User();
        user1.setName("陈立其");
        user1.setAge(22);
        user1.setBirthday(dateFormat.parse("1996-11-09"));
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        String jsonList = mapper.writeValueAsString(list);
        System.out.println(jsonList);
    }
}
