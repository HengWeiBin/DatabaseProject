package com.project.stella_boutique.service.seller.product.remove;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.item.Item;
import com.project.stella_boutique.service.exception.RemoveProductErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class RemoveSellerProductUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public RemoveSellerProductUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(RemoveSellerProductUseCaseInput input, RemoveSellerProductUseCaseOutput output) throws RemoveProductErrorException{
        System.out.println("service~");
        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE `item` SET `quantity`=?  WHERE `id`=? ")) {                    
                stmt.setString(1, Integer.toString(0));
                stmt.setString(2, Integer.toString(input.getItemID()));

                stmt.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        output.setItemID(input.getItemID());
    }
    
}