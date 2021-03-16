package com.project.stella_boutique.service.guest.rate;

import com.project.stella_boutique.adapter.database.MysqlDriver;
import com.project.stella_boutique.model.rate.Rate;
import com.project.stella_boutique.service.exception.GetRateErrorException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class GetRateUseCase {
    @Autowired
    private MysqlDriver mysqlDriver;

    public GetRateUseCase(MysqlDriver mysqlDriver){
        this.mysqlDriver = mysqlDriver;
    }

    public void execute(GetRateUseCaseInput input, GetRateUseCaseOutput output) throws GetRateErrorException {
        //code
    }
}