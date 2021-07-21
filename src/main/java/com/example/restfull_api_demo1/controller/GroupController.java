package com.example.restfull_api_demo1.controller;


import com.example.restfull_api_demo1.entity.Group;
import com.example.restfull_api_demo1.entity.User;
import com.example.restfull_api_demo1.service.GroupService;
import com.example.restfull_api_demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<Group> users = groupService.getListGroup();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        Group result = groupService.getGroupById(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam( name = "k",required = false ,defaultValue = "") String keyword){
        List<Group> users= groupService.searchGroups(keyword);
        return  ResponseEntity.ok(users);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody List<Group> users){
        List<Group> listUser=groupService.create(users);
        return ResponseEntity.ok(listUser);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody Group group){
        List<Group> users= groupService.update(group);
        //System.out.println(user.toString());
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(groupService.delete(id));
    }
}
