package com.project.stella_boutique.service.user.order.item.update;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.service.exception.UpdateOrderErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UpdateOrderUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public UpdateOrderUseCase(MysqlDriver mysqlDriver) {
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(UpdateOrderUseCaseInput input, UpdateOrderUseCaseOutput output) throws UpdateOrderErrorException {
        //code
    }
}