// package com.project.stella_boutique.service;

// import com.project.stella_boutique.adapter.database.MysqlDriver;
// import com.project.stella_boutique.service.GuestService;

// import com.project.stella_boutique.model.discount.Discount;
// import com.project.stella_boutique.model.item.*;
// import com.project.stella_boutique.model.order.Order;
// import com.project.stella_boutique.model.user.User;
// import com.project.stella_boutique.service.GuestService;

// import org.springframework.stereotype.Service;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.UUID;

// @Service
// public class UserService {

//     private MysqlDriver mysqlDriver = new MysqlDriver();

//     public void AddUser(User user) {
//         try(Connection connection = this.mysqlDriver.getConnection()){
//             try (PreparedStatement stmt = connection.prepareStatement(
//                 "INSERT IGNORE INTO `user` VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
//                 stmt.setString(1, String.valueOf(user.getUserID()));
//                 stmt.setString(2, user.getPassword());
//                 stmt.setString(3, user.getFullName());
//                 stmt.setString(4, user.getUsername());
//                 stmt.setString(5, user.getBirthday());
//                 stmt.setString(6, user.getAddress());
//                 stmt.setString(7, user.getPhoneNumber());
//                 stmt.setString(8, user.getEmail());

//                 stmt.executeUpdate();

//             }catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

   
//     /*
//     public void AddUser(User user) {
//         insert into user
//     }
//     public void Login(User user) {

//     }
//     public void CreateOrder() {
//         insert into order
//     }
//     public void AddItemList() {
//         insert into item list
//     }
//     public void UpdateItemist() {
//         update item list (update amount)
//     }
//     public void RemoveItemist() {
//         remove item list
//     }
//     public void UseDiscount() {
//         update order entity (update discID)
//     }
//     public void checkoutOrder() {
//         update order entity (order status)
//     }
//     public void UpdateStock() {
//         update the stock of product when user checkout
//     }
//     public void getOrderHistory(User user) {
//         get all the user order from order join itemlist(amount) join item(name) join disc(disc name)
//     }
//     public void GetLikeItem(User user) {

//     }
//     public void RemoveLikeItem(User user) {

//     }
//     */

// }
