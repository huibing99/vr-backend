package com.example.demo1.controller;

import com.example.demo1.Entity.User;
import com.example.demo1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/GetAllUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping(value = "/GetUser")
    public User getUserByNumber(@RequestParam("jobNumber") String jobNumber){
        System.out.println(jobNumber);
        return userService.findByJobNumber(jobNumber);
    }

    @PostMapping(value = "/CreateUser")
    public User createUser(@RequestParam("userName") String userName,
                           @RequestParam("jobNumber") String jobNumber,
                           @RequestParam("password") String password){
        User user = new User();
        user.setUserName(userName);
        user.setJobNumber(jobNumber);
        user.setPassword(password);
        userService.insertUser(user);
        return user;
    }


    @RequestMapping(value = "/Login")
    public String Login(@RequestBody User user){
        //数据库设置管理员名单，进行权限比对
        String adminList = "TTTest";
        Boolean isAdmin = false;

        // 验证数据信息
        if (user == null || user.getJobNumber() == null || user.getPassword() == null) {
            return "请输入信息";
        }

        //默认工号是唯一的，按照工号查找
        User uerCheck = userService.findByJobNumber(user.getJobNumber());
        if(uerCheck == null){
            System.out.println("用户不存在，自动注册");
            userService.insertUser(user);
            return "已自动注册，欢迎登陆";
        }
        else {
            if(uerCheck.getPassword().equals(user.getPassword())){
                System.out.println("用户存在，匹配成功");

                //此处不应该是==，以工号比对确定是否有管理员权限
                if(uerCheck.getJobNumber() == adminList){
                    isAdmin = true;

                    //判断是管理员后再显示相应的管理界面
                    //......//
                    return "显示管理员界面";
                }
                return "普通用户界面";
            }
            else {
                return "信息输入有误";
            }
        }
    }
}
