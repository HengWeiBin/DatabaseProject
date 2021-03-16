package com.project.stella_boutique.service.guest.discount;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.service.exception.GetDiscountErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
@Service
public class GetDiscountUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetDiscountUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetDiscountUseCaseInput input, GetDiscountUseCaseOutput output) throws GetDiscountErrorException {
        List<Discount> discountList = new ArrayList<>();   
        Date currentDate = input.getCurrentDate(); 
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
                        if(id!=1 && currentDate.compareTo(disc.getStartDate()) > 0 && currentDate.compareTo(disc.getEndDate()) < 0){
                            discountList.add(disc);
                        }
                    }
                }
            }
        }catch (SQLException e) {
            System.out.println("Unable to Get Discount from MySQL~~");
            e.printStackTrace();
        }
        output.setDiscountList(discountList);
    }
    public void sellerExecute(GetDiscountUseCaseInput input, GetDiscountUseCaseOutput output) throws GetDiscountErrorException {
        List<Discount> discountList = new ArrayList<>();   
        Date currentDate = input.getCurrentDate(); 
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
                        if(id!=1){
                            discountList.add(disc);
                            
                        }
                    }
                }
            }
        }catch (SQLException e) {
            System.out.println("Unable to Get Discount from MySQL~~");
            e.printStackTrace();
        }
        output.setDiscountList(discountList);
    }
}