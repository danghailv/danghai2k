package com.example.restfull_api_demo1.dao;

import com.example.restfull_api_demo1.entity.Group;

import java.util.List;

public interface GroupDAO {
    List<Group> getAll();
    void insertUser(Group group);
    void updateUser(Group group);
    void deleteUser(int gr);
}
