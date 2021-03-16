package com.project.stella_boutique.service.seller.product.add;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.item.Item;
import com.project.stella_boutique.service.exception.AddProductErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class AddSellerProductUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public AddSellerProductUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(AddSellerProductUseCaseInput input, AddSellerProductUseCaseOutput output) throws AddProductErrorException {

        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT `item` (`name`, `quantity`, `category`, `size`, `price`, `description`, `pictureURL` )" +
                    " VALUES (?,?,?,?,?,?,?)"
                )) {
                    stmt.setString(1, input.getName());
                    stmt.setString(2, Integer.toString(input.getQuantity()));
                    stmt.setString(3, input.getCategory());
                    stmt.setString(4, input.getSize());
                    stmt.setString(5, Integer.toString(input.getPrice()));
                    stmt.setString(6, input.getDescription());
                    stmt.setString(7, input.getPictureURL());

                    stmt.executeUpdate();
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        output.setName(input.getName());
    }
}