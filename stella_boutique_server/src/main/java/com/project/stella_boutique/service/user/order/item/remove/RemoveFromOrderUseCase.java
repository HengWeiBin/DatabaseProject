package com.project.stella_boutique.service.user.order.item.remove;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.RemoveFromOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RemoveFromOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public RemoveFromOrderUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(RemoveFromOrderUseCaseInput input, RemoveFromOrderUseCaseOutput output) throws RemoveFromOrderErrorException {
        //code
    }
}