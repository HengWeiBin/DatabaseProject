package com.project.stella_boutique.service.seller.order.update;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.order.Order;
import com.project.stella_boutique.service.exception.UpdateOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UpdateSellerOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public UpdateSellerOrderUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(UpdateSellerOrderUseCaseInput input, UpdateSellerOrderUseCaseOutput output) throws UpdateOrderErrorException {
        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE `order` SET `status`=? WHERE `id`= ? ")) {
                    stmt.setString(1, Integer.toString(input.getStatus()));
                    stmt.setString(2, Integer.toString(input.getOrderID()));
                
                    stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}