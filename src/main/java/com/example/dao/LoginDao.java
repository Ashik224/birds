package com.example.dao;

import com.example.Database;
import com.example.LoginInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Database database = new Database();
    public LoginInfo retrieveLogin(String userName) throws SQLException, ClassNotFoundException {
        LoginInfo loginInfo = null;
        Connection connection = database.getConnection();
        String query = "select username, password from login where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) {
            String username = rs.getString(1);
            String password = rs.getString(2);
            loginInfo = new LoginInfo(username,password);
        }
        return loginInfo;
    }
}
