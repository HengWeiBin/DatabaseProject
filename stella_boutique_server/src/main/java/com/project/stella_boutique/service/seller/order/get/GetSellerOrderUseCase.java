package com.project.stella_boutique.service.seller.order.get;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.order.Order;
import com.project.stella_boutique.model.item.Item;
import com.project.stella_boutique.service.exception.GetOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

@Service
public class GetSellerOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetSellerOrderUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetSellerOrderUseCaseOutput output) throws GetOrderErrorException {
        List<Order> orderList = new ArrayList<>();   
        List<Item> itemList = new ArrayList<>();
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM `order` ORDER BY `status` ASC")) {
                try (ResultSet rs = stmt.executeQuery()) { 
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        int status = Integer.parseInt(rs.getString("status"));
                        String orderDate = rs.getString("orderDate");
                        int discountID = Integer.parseInt(rs.getString("discountID"));
                        int userID = Integer.parseInt(rs.getString("orderUserID"));
                        
                        Order order = new Order(id, status, orderDate, discountID, userID);
                        System.out.println("this order");
                        itemList = getItemByOrder(id,connection);
                        order.setItemList(itemList);
                        System.out.println("each order");
                        for(int i=0;i<order.getItemList().size();i++){
                            System.out.println(order.getItemList().get(i).getName());
                        }

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
        System.out.println("---------get discount value--------");
        try (PreparedStatement stmt = connection.prepareStatement(
            "SELECT `value` FROM `discount` WHERE `id`= ?")) {
                stmt.setString(1, String.valueOf(discountID));
            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    double value = rs.getDouble("value");

                    System.out.println("disocunt");
                    System.out.println(value);
                    order.setValue(value);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}