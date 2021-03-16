package com.project.stella_boutique.service.management.user;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.user.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.project.stella_boutique.service.exception.LoginErrorException;

import java.util.List;
import java.util.ArrayList;
@Service
public class GetUserUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetUserUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetUserUseCaseOutput output)throws LoginErrorException{
        List<User> userList = new ArrayList<>();    
        System.out.println("service~");
        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM `user`")) {
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
                            
                            System.out.println(fullName);

                            User user = new User(id, password, fullName, username, birthday, address, phoneNumber, email);
                            userList.add(user);
                        }
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        output.setUserList(userList);
    }   
}