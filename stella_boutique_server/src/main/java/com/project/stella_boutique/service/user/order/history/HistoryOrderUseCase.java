package com.project.stella_boutique.service.user.order.history;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.HistoryOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import com.project.stella_boutique.model.order.Order;
import com.project.stella_boutique.model.item.Item;

@Service
public class HistoryOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public HistoryOrderUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(HistoryOrderUseCaseInput input, HistoryOrderUseCaseOutput output) throws HistoryOrderErrorException {
        List<Order> orderList = new ArrayList<>();    
        List<Item> itemList = new ArrayList<>();
        try(Connection connection=this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM `order` WHERE `orderUserID`= ? ORDER BY `status` ASC ")) {
                    stmt.setString(1, Integer.toString(input.getUserID()));
                try (ResultSet rs = stmt.executeQuery()) {
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        String orderDate = rs.getString("orderDate");
                        int status = Integer.parseInt(rs.getString("status"));
                        String discount =  rs.getString("discountID");
                        int discountID = Integer.parseInt(rs.getString("discountID"));

                        Order order = new Order(id,status,orderDate,discountID,input.getUserID());
                        itemList = getItemByOrder(id,connection);
                        order.setItemList(itemList);
                        getDiscountValue(connection,discountID,order);
                        order.getTotalPrice();
                        orderList.add(order);
                    }
                }   
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        output.setOrderList(orderList);
    }
    public List<Item> getItemByOrder(int orderID,Connection connection){
        List<Item> boughtItem = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT * FROM `itemlist` il JOIN `item` i WHERE il.orderItemId = i.id and il.orderID = ?")) {
                stmt.setString(1, Integer.toString(orderID));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    int itemID = Integer.parseInt(rs.getString("orderItemID"));
                    int amount = Integer.parseInt(rs.getString("amount"));
                    int id = Integer.parseInt(rs.getString("id"));
                    String name = rs.getString("name");
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    String category = rs.getString("category");
                    String size = rs.getString("size");
                    Float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    String pictureURL = rs.getString("pictureURL");
    
                    Item item = new Item(id, name, quantity, category, size, price, description, pictureURL);
                    item.setBuyAmount(amount);
                    
                    System.out.println(item.getName());
                    System.out.println(item.getBuyAmount() + " + " + item.getPrice() );
                    System.out.println("total");
                    System.out.println(item.getBuyAmount()*item.getPrice());
                    
                    boughtItem.add(item);
                    // int priceMulAmount = Math.round(boughtItem.getPrice()) * amount;
                    // order.setPrice(priceMulAmount);

                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return boughtItem;
    }   
    public void getDiscountValue(Connection connection,int discountID,Order order){
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT `value` FROM `discount` WHERE `id`= ?")) {
                stmt.setString(1, String.valueOf(discountID));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    double value = rs.getDouble("value");

                    order.setValue(value);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}