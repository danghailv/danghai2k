package com.example.restfull_api_demo1.service;

import com.example.restfull_api_demo1.entity.Group;
import com.example.restfull_api_demo1.entity.User;


import java.util.List;

public interface GroupService {
    List<Group> getListGroup();
    Group getGroupById(int id);
    List<Group> searchGroups(String keywrod);
    List<Group> update(Group group);
    Group delete (int keyword);
    List<Group> create( List<Group> groups);
}
