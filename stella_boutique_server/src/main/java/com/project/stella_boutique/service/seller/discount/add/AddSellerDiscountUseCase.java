package com.project.stella_boutique.service.seller.discount.add;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.service.exception.AddDiscountErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AddSellerDiscountUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public AddSellerDiscountUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(AddSellerDiscountUseCaseInput input, AddSellerDiscountUseCaseOutput output) throws AddDiscountErrorException{
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO `discount` (`value`,`code`,`name`,`startDate`,`endDate`)"
                + "VALUES(?,?,?,?,?)")) {
                    stmt.setString(1, Float.toString(input.getValue()));
                    stmt.setString(2, input.getCode());
                    stmt.setString(3, input.getName());
                    stmt.setString(4, input.getStartDateString());
                    stmt.setString(5, input.getEndDateString());

                    stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}