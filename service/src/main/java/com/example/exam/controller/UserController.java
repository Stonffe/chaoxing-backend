package com.example.exam.controller;

import com.example.exam.dto.LoginDto;
import com.example.exam.entity.User;
import com.example.exam.resp.RestResp;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: UserController
 * @Author: Stonffe
 * @Date: 2024/4/17 18:40
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public RestResp<Map<String,String>> login(LoginDto loginDto) {
        Map<String, String> map = new HashMap<>();
        return RestResp.ok(map);
    }
}
