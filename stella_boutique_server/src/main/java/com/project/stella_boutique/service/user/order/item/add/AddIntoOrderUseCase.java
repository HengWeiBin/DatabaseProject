package com.project.stella_boutique.service.user.order.item.add;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.AddIntoOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AddIntoOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public AddIntoOrderUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(AddIntoOrderUseCaseInput input, AddIntoOrderUseCaseOutput output) throws AddIntoOrderErrorException {
        System.out.println("add item to order");
        // try(Connection connection = this.mysqlDriver.getConnection()) {
        //     try (PreparedStatement stmt = connection.prepareStatement(
        //             "INSERT INTO `itemlist`" +
        //             "VALUES(?, ?, ?)"
        //         )) {
        //             stmt.setString(1, input.getOrderDateString());
        //             stmt.setString(2, String.valueOf(input.getStatus()));
        //             stmt.setString(3, String.valueOf(input.getUserID()));

        //             stmt.executeUpdate();
        //         }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
    } 
    
}