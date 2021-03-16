package com.project.stella_boutique.service.user.order.add;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.AddOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

@Service
public class AddOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public AddOrderUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(AddOrderUseCaseInput input,AddOrderUseCaseOutput output) throws AddOrderErrorException {
     
        try(Connection connection = this.mysqlDriver.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO `order`" +
                    "(`orderDate`,`status`,`discountID`,`orderUserID`)" +
                    "VALUES(?, ?, ?, ?)"
                )) {
                    stmt.setString(1, input.getOrderDateString());
                    stmt.setString(2, String.valueOf(input.getStatus()));                    stmt.setString(2, String.valueOf(input.getStatus()));
                    stmt.setString(3, String.valueOf(input.getDiscountID()));
                    stmt.setString(4, String.valueOf(input.getUserID()));
                    stmt.executeUpdate();
                    getOrderID(connection,input,output);
                    addToItemList(connection,input,output);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    public void getOrderID(Connection connection,AddOrderUseCaseInput input,AddOrderUseCaseOutput output){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT `id` FROM `order` WHERE `orderUserID`= ? && `orderDate` = ?")) {
                    stmt.setString(1, Integer.toString(input.getUserID()));
                    stmt.setString(2, input.getOrderDateString());
                try (ResultSet rs = stmt.executeQuery()) {
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        
                        output.setId(id);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addToItemList(Connection connection,AddOrderUseCaseInput input,AddOrderUseCaseOutput output) throws AddOrderErrorException {
        for(int i =0;i<input.getItemListLength();i++){
            int itemId = Integer.parseInt(input.getItemNo(i));
            Boolean status = isInItemList(connection,itemId,output.getId());
            if(status && itemId != 0 ){
                int itemAmount = getAmount(connection,itemId,output.getId())+1;
           
                try (PreparedStatement stmt = connection.prepareStatement(
                        "UPDATE `itemlist` SET `amount`=?" +
                        "WHERE orderID = ? AND orderItemID =?"
                    )) {
                        
                   
                        stmt.setString(1, String.valueOf(itemAmount));
                        stmt.setString(2, String.valueOf(output.getId()));
                        stmt.setString(3, String.valueOf(itemId));


                        stmt.executeUpdate();
                   
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            
            }else if (itemId != 0){
                try (PreparedStatement stmt = connection.prepareStatement(
                        "INSERT `itemlist` VALUES(?,?,?)"
                    )) {                        
                        stmt.setString(1, String.valueOf(itemId));
                        stmt.setString(2, String.valueOf(output.getId()));
                        stmt.setString(3, String.valueOf(1));

                        stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            }
           
        }
        
    } 
    public Boolean isInItemList(Connection connection,int itemID, int orderID){
        Boolean status=false;
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT `orderItemID` FROM `itemlist` WHERE `orderID`= ?")) {
                stmt.setString(1, String.valueOf(orderID));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    int id = Integer.parseInt(rs.getString("orderItemID"));   
                    if(Integer.toString(itemID).equals(Integer.toString(id))){
                        status = true;
                        break;
                    }else{
                        status = false;
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public int getAmount(Connection connection,int itemID, int orderID){
        int itemAmount = 0;
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT `amount` FROM `itemlist` WHERE `orderID`= ? AND `orderItemID`=? ")) {
                stmt.setString(1, String.valueOf(orderID));
                stmt.setString(2, String.valueOf(itemID));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    int amount = Integer.parseInt(rs.getString("amount"));

                    itemAmount = amount;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return itemAmount;
    }
    


}
