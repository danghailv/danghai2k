package com.example.restfull_api_demo1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private Connection connection=null;
    public ConnectDB(){
        try {
            String connectionURL="jdbc:mysql://localhost:3306/QUANLYTINTUC";
            String user="root";
            String password="haigay123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(connectionURL,user,password);
            System.out.println("Connection thành công database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn() {
        return connection;
    }
}
