package com.example.restfull_api_demo1.dao;

import com.example.restfull_api_demo1.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOimpl implements UserDAO{
    @Override
    public List<User> getAll() {
        List<User>lists = new ArrayList<>();
        try {
            String sql= "SELECT * FROM QUANLYTINTUC.Users";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                User user= new User();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setGroupid(resultSet.getInt("groupid"));
                lists.add(user);

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
    public void  insertUser(User user) {
        try {
            String sql= "INSERT INTO QUANLYTINTUC.Users (username, email,groupid) VALUES ( ?, ?, ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setInt(3,user.getGroupid());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String sql= "UPDATE QUANLYTINTUC.Users SET username = ? , email = ?, groupid = ? WHERE (userid = ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setInt(3,user.getGroupid());
            preparedStatement.setInt(4,user.getUserid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            String sql= "DELETE FROM QUANLYTINTUC.Users WHERE (userid = ?);";
            Connection connection=new ConnectDB().getConn();
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
