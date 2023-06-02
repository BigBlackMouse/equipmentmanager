package com.sicau.springbootequipmentmanager.equipmentmanager.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.component.JwtComponent;
import com.sicau.springbootequipmentmanager.equipmentmanager.common.result.Result;
import com.sicau.springbootequipmentmanager.equipmentmanager.dto.UserInfo;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.entity.User;
import com.sicau.springbootequipmentmanager.equipmentmanager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtComponent jwtComponent;
    @RequestMapping("/login")
    public Result<?> login(@RequestBody UserInfo userInfo){
        User user = userService.getUserInfo(userInfo);
        if (Objects.isNull(user)){
            return new Result<>().error();
        }
        String token = jwtComponent.sign(userInfo.getUserName(), userInfo.getUserPassword());
        JSONObject object = new JSONObject();
        object.put("token",token);
        object.put("user",user);
        return new Result<>().success().put(object);
    }
}
