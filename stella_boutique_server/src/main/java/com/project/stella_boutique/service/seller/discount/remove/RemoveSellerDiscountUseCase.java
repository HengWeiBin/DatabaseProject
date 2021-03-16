package com.project.stella_boutique.service.seller.discount.remove;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.service.exception.RemoveDiscountErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RemoveSellerDiscountUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public RemoveSellerDiscountUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(RemoveSellerDiscountUseCaseInput input, RemoveSellerDiscountUseCaseOutput output) throws RemoveDiscountErrorException {
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "DELETE `discount` WHERE ``id`=?")) {
                    stmt.setString(1, Integer.toString(input.getDiscountID()));

                    stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}