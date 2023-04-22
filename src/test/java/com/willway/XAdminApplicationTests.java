package com.willway;

import com.baomidou.mybatisplus.extension.service.IService;

import com.willway.sys.entity.User;
import com.willway.sys.mapper.UserMapper;
import com.willway.sys.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class XAdminApplicationTests {

    @Resource
    private IUserService iUserService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testMapper(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testHash(){
        HashMap<Object, Object> map = new HashMap<>(6);
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

    }
    @Test
    public void testGetRoleNameByUserId(){
        List<String> roleNameList = userMapper.getRoleNameByUserId(1);
        roleNameList.forEach(System.out::println);
    }

}
