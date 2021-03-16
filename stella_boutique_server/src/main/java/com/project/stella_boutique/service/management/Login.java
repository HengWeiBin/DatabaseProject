package com.project.stella_boutique.service.management;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.user.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Login {
    @Autowired
    private MysqlDriver mysqlDriver = new MysqlDriver();

    public User findByUsername(String usernameInput, String passwordInput) {
        User user = null;

        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM `user` WHERE `username` = ? and `password` = ?")) {
                    stmt.setString(1, usernameInput);
                    stmt.setString(2, passwordInput);

                    try (ResultSet rs = stmt.executeQuery()) {
                        while(rs.next()) {
                            int id = Integer.parseInt(rs.getString("id"));
                            String password = rs.getString("password");
                            String fullName = rs.getString("fullname");
                            String username = rs.getString("username");
                            String birthday = rs.getString("birthday");
                            String address = rs.getString("address");
                            String phoneNumber = rs.getString("phoneNumber");
                            String email = rs.getString("email"); 
                            
                            user = new User(id, password, fullName, username, birthday, address, phoneNumber, email);
                        }
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }   
}