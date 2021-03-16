package com.project.stella_boutique.service;

import com.project.stella_boutique.adapter.database.MysqlDriver;

import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.model.item.*;
import com.project.stella_boutique.model.order.Order;
import com.project.stella_boutique.model.user.User;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


@Service
public class SellerService {

    private MysqlDriver mysqlDriver = new MysqlDriver();
    public static final String DATE_FORMAT = "yyyy/MM/dd";
    
    public List<Item> GetProduct(){
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
        return productList;
    }

    public List<Discount> GetDiscount(String CurrentDate){
        final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date curDate;
        try {
            curDate = dateFormat.parse(CurrentDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid Curent Date: " + CurrentDate);
        }

        List<Discount> discountList = new ArrayList<>();   
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM `discount`")) {
                try (ResultSet rs = stmt.executeQuery()) { 
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("id"));
                        Float value = rs.getFloat("value");
                        String code = rs.getString("code");
                        String discountName = rs.getString("name");
                        String startDate = rs.getString("startDate").replace("-","/");
                        String endDate = rs.getString("endDate").replace("-","/");

                        Discount disc = new Discount(id, value, discountName, startDate, endDate, code);

                        //get the voucher that available on the current date
                        if(curDate.compareTo(disc.getStartDate()) > 0 && curDate.compareTo(disc.getEndDate()) < 0){
                            discountList.add(disc);
                        }
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return discountList;
    }

    public void getRate(Item item,Connection connection) throws SQLException{
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

    // public void AddProduct(){
    //     try(Connection connection = this.mysqlDriver.getConnection()){
    //         try (PreparedStatement stmt = connection.prepareStatement(
    //             "INSERT INTO `discount` (`id`,`value`,`code`,`name`,`startDate`,`endDate`)"
    //             + "VALUES(?,?,?,?,?,?)")) {
    //                 stmt.setString(1, Integer.toString(input.getDiscountID()));
    //                 stmt.setString(2, Float.toString(input.getValue()));
    //                 stmt.setString(3, input.getCode());
    //                 stmt.setString(4, input.getDiscountName());
    //                 stmt.setString(5, SqlDateTimeConverter.toString(input.setEndDate());
    //                 stmt.setString(6, SqlDateTimeConverter.toString(input.getEndDate());

    //                 stmt.executeUpdate();
    //         }
    //     }catch (SQLException e) {
    //         e.printStackTrace();
    //     }finally{
    //         this.mysqlDriver.closeConnection();
    //     }
    //     output.setDiscountName(input.getDiscountName());
    // }
    // }

   /*
    public void UpdateProduct(){
        update product
    }
    public void RemoveProduct(){
        delete from product
    }
    
    public void AddDiscount(){
       insert into product
    }
    public void UpdateDiscount(){
        update product
    }
    public void RemovePDiscount(){
        delete from product
    }

    public void UpdateOrderStatus(){
        update order entity (order status)
    }

    public GetOrderList(){
        get all the user order from order join itemlist(amount) join item(name) join disc(disc name)
    }
    */

}
