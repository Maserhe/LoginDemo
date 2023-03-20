package com.xencio.controller;

import com.xencio.common.Result;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @RequiresRoles("1")
    @RequestMapping("/authorization1")
    public Result testAuthorization1() {
        return Result.succ("拥有权限1");
    }


    @RequiresRoles("2")
    @RequestMapping("/authorization2")
    public Result testAuthorization2() {
        return Result.succ("拥有权限2");
    }

    @RequiresAuthentication
    @RequestMapping("/authentication")
    public Result tesAuthentication() {
        return Result.succ("认证成功");
    }


    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

}
