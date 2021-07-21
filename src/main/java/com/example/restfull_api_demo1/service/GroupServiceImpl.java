package com.example.restfull_api_demo1.service;

import com.example.restfull_api_demo1.dao.GroupDAO;
import com.example.restfull_api_demo1.entity.Group;
import com.example.restfull_api_demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GroupServiceImpl implements GroupService{
    @Autowired
    GroupDAO groupDAO;
    @Override
    public List<Group> getListGroup() {
        return groupDAO.getAll();
    }

    @Override
    public Group getGroupById(int id) {
        for (Group group: groupDAO.getAll()){
            if(group.getGroupid()==id){
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> searchGroups(String keywrod) {

        List<Group> result = new ArrayList<>();
        for(Group group :groupDAO.getAll()){
            if(group.getTitle().contains(keywrod)){
                result.add(group);
            }
        }
        return result;
    }

    @Override
    public List<Group> update(Group group) {
        groupDAO.updateUser(group);
        return getListGroup();
    }

    @Override
    public Group delete(int keyword) {
        Group group = getGroupById(keyword);
        groupDAO.deleteUser(keyword);
        return group;
    }

    @Override
    public List<Group> create(List<Group> groups) {
        for (Group group: groups) {
            groupDAO.insertUser(group);
        }
        return getListGroup();
    }
}
