package com.project.stella_boutique.service.seller.discount.get;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.service.exception.GetDiscountErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


@Service
public class GetSellerDiscountUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetSellerDiscountUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetSellerDiscountUseCaseOutput output) throws GetDiscountErrorException {
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