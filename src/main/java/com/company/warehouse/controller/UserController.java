package com.company.warehouse.controller;

import com.company.warehouse.entity.User;
import com.company.warehouse.payload.Result;
import com.company.warehouse.payload.UserDto;
import com.company.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public Result addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        return result;
    }
    @GetMapping
    public List<User> userList(){
        List<User> userAll = userService.getUserAll();
        return userAll;
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.getUser(id);
        return user;
    }
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result = userService.deleteUser(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        Result result = userService.editUser(id, userDto);
        return result;
    }
}
