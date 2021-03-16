package com.project.stella_boutique.service.guest.product;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.item.Item;
import com.project.stella_boutique.service.exception.GetProductErrorException;
import com.project.stella_boutique.service.exception.GetRateErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;


@Service
public class GetProductUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetProductUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetProductUseCaseOutput output) throws GetProductErrorException{
        List<Item> productList = new ArrayList<>();    
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM `item` WHERE `quantity` != 0")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        String name = rs.getString("name");
                        int quantity = Integer.parseInt(rs.getString("quantity"));
                        String category = rs.getString("category");
                        String size = rs.getString("size");
                        Float price = rs.getFloat("price");
                        String description = rs.getString("description");
                        String pictureURL = rs.getString("pictureURL");
    
                        Item item = new Item(id, name, quantity, category, size, price, description, pictureURL);
                        getRate(item,connection);
                        productList.add(item);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        output.setProductList(productList);
    }

    public void getRate(Item item,Connection connection){
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT * FROM `rate` WHERE `rateItemID` =  ?")) {
                stmt.setString(1, Integer.toString(item.getItemID()));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    String comment = rs.getString("comment");
                    int rate = Integer.parseInt(rs.getString("rate"));

                    item.setRatings(comment,rate);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
