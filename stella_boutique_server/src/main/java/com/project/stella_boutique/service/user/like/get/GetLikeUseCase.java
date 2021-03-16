package com.project.stella_boutique.service.user.like.get;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.GetLikeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@Service
public class GetLikeUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetLikeUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetLikeUseCaseInput input, GetLikeUseCaseOutput output) throws GetLikeErrorException {
        List<Integer> itemList = new ArrayList<>();    
        try(Connection connection = this.mysqlDriver.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM `like` WHERE `userID` = ?")) {
                    stmt.setString(1, Integer.toString(input.getUserID()));
                try (ResultSet rs = stmt.executeQuery()) {
                    while(rs.next()) {
                        int id = Integer.parseInt(rs.getString("itemID"));
                        
                        itemList.add(id);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        output.setLikeList(itemList);
    }

}