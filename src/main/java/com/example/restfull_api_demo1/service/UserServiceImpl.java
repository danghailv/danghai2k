package com.example.restfull_api_demo1.service;


import com.example.restfull_api_demo1.dao.UserDAO;
import com.example.restfull_api_demo1.dao.UserDAOimpl;
import com.example.restfull_api_demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;
    UserDAOimpl a = new UserDAOimpl();

    @Override
    public List<User> getListUser() {
        return userDAO.getAll();
    }

    @Override
    public User getUserById(int id) {
        for (User user: userDAO.getAll()){
            if(user.getUserid()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> searchUser(String keywrod) {
        List<User> result = new ArrayList<>();
        for(User user :userDAO.getAll()){
            if(user.getUsername().contains(keywrod)){
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<User> update(User user) {
        userDAO.updateUser(user);
        return getListUser();
    }

    @Override
    public User delete(int  keyword) {
        User user = getUserById(keyword);
        userDAO.deleteUser(keyword);
        return user;
    }

    @Override
    public List<User> create(List<User> users) {
        for (User user: users) {
            userDAO.insertUser(user);
        }
        return getListUser();
    }
}
