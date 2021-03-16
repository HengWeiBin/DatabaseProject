package com.project.stella_boutique.service.seller.discount.update;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.service.exception.UpdateDiscountErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UpdateSellerDiscountUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public UpdateSellerDiscountUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(UpdateSellerDiscountUseCaseInput input, UpdateSellerDiscountUseCaseOutput output) throws UpdateDiscountErrorException {
        //code
        /*"update `discount` SET `value`=?,`code`=?,`name`=?,
        `startDate`=?,`endDate`=? WHERE id=?  */
    }
}