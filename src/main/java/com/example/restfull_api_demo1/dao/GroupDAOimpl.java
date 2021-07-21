package com.example.restfull_api_demo1.dao;

import com.example.restfull_api_demo1.dao.GroupDAO;
import com.example.restfull_api_demo1.entity.Group;
import com.example.restfull_api_demo1.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupDAOimpl implements GroupDAO {
    @Override
    public List<Group> getAll() {
        List<Group>lists = new ArrayList<>();
        try {
            String sql= "SELECT * FROM QUANLYTINTUC.groupss;";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                Group group= new Group();
                group.setGroupid(resultSet.getInt("groupid"));
                group.setTitle(resultSet.getString("title"));
                group.setLevel(resultSet.getInt("LEVEL"));
                lists.add(group);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return lists;
    }

    @Override
    public void insertUser(Group group) {
        try {
            String sql= "INSERT INTO QUANLYTINTUC.groupss (groupid, title,LEVEL) VALUES (?, ?, ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,group.getGroupid());
            preparedStatement.setString(2,group.getTitle());
            preparedStatement.setInt(3,group.getLevel());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUser(Group group) {
        try {
            String sql= "UPDATE QUANLYTINTUC.groupss SET title = ? , LEVEL = ? WHERE (groupid   = ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,group.getTitle());
            preparedStatement.setInt(2,group.getLevel());
            preparedStatement.setInt(3,group.getGroupid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int gr) {
        try {
            String sql= "DELETE FROM QUANLYTINTUC.groupss WHERE (groupid = ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,gr);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
