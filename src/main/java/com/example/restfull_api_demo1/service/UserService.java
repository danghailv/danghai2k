package com.example.restfull_api_demo1.service;


import com.example.restfull_api_demo1.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<User> getListUser();
     User getUserById(int id);
     List<User> searchUser(String keywrod);
     List<User> update(User user);
     User delete (int keyword);
     List<User> create( List<User> users);
}
