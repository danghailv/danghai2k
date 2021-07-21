package com.example.restfull_api_demo1.dao;

import com.example.restfull_api_demo1.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(int id);

}
