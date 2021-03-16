package com.project.stella_boutique.service.user.like.remove;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.RemoveLikeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class RemoveLikeUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public RemoveLikeUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(RemoveLikeUseCaseInput input, RemoveLikeUseCaseOutput output) throws RemoveLikeErrorException {
        System.out.println("remove like");
        System.out.println(input.getItemID());

        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM `like` WHERE userID = ? AND itemID = ?"
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