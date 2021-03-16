package com.project.stella_boutique.service.user.like.add;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.AddLikeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class AddLikeUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public AddLikeUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(AddLikeUseCaseInput input, AddLikeUseCaseOutput output) throws AddLikeErrorException{
        System.out.println("add like");
        System.out.println(input.getItemID());

        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO `like` VALUES(?, ?)"
                )) {
                    stmt.setString(1, Integer.toString(input.getUserID()));
                    stmt.setString(2, Integer.toString(input.getItemID()));

                    stmt.executeUpdate();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        output.setItemID(input.getItemID());
    }

}