package com.example.restfull_api_demo1.controller;


import com.example.restfull_api_demo1.dao.ConnectDB;
import com.example.restfull_api_demo1.entity.User;
import com.example.restfull_api_demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<User> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        User result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam( name = "k",required = false ,defaultValue = "") String keyword){
        List<User> users= userService.searchUser(keyword);
        return  ResponseEntity.ok(users);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody List<User> users){
        List<User> listUser=userService.create(users);
        return ResponseEntity.ok(listUser);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        List<User> users= userService.update(user);
        //System.out.println(user.toString());
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
