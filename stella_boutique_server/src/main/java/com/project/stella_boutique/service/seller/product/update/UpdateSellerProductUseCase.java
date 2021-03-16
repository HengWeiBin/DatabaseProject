package com.project.stella_boutique.service.seller.product.update;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.item.Item;
import com.project.stella_boutique.service.exception.UpdateProductErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UpdateSellerProductUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public UpdateSellerProductUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(UpdateSellerProductUseCaseInput input, UpdateSellerProductUseCaseOutput output) throws UpdateProductErrorException {
        System.out.println("service~");
        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE `item` SET `name`=? , `price` =? , `description`=? WHERE `id`=? ")) {                    
                stmt.setString(1, input.getName());
                stmt.setString(2, Integer.toString(input.getPrice()));
                stmt.setString(3, input.getDescription());
                stmt.setString(4, Integer.toString(input.getItemID()));

                System.out.println(input.getPrice());
                stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        output.setItemID(input.getItemID());
    }
}