package com.willway.sys.controller;

import com.willway.common.vo.Result;
import com.willway.sys.entity.User;
import com.willway.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author will
 * @since 2023-03-27
 */
@RestController
@RequestMapping("/user")
public class   UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/all")
    public Result<List<User>> getAllUSer(){
        List<User> list = iUserService.list();
        return Result.success(list, "查询成功");
    }
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user){
        Map<String, Object> data = iUserService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20002, "用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token){
        Map<String, Object> data = iUserService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20003, "登录信息无效，请重新登录 ");
    }

}
