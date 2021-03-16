package com.project.stella_boutique.rest;

import com.project.stella_boutique.service.guest.rate.GetRateUseCase;
import com.project.stella_boutique.service.guest.rate.GetRateUseCaseInput;
import com.project.stella_boutique.service.guest.rate.GetRateUseCaseOutput;
import com.project.stella_boutique.service.guest.product.GetProductUseCase;
import com.project.stella_boutique.service.guest.product.GetProductUseCaseOutput;
import com.project.stella_boutique.service.guest.discount.GetDiscountUseCase;
import com.project.stella_boutique.service.guest.discount.GetDiscountUseCaseInput;
import com.project.stella_boutique.service.guest.discount.GetDiscountUseCaseOutput;
import com.project.stella_boutique.service.management.add.*;
import com.project.stella_boutique.service.management.login.*;


import com.project.stella_boutique.service.exception.GetDiscountErrorException;
import com.project.stella_boutique.service.exception.GetProductErrorException;
import com.project.stella_boutique.service.exception.GetRateErrorException;
import com.project.stella_boutique.service.exception.LoginErrorException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/api/guest")
public class GuestRestAdapter {
    @Autowired
    GetRateUseCase getRateUseCase;

    @Autowired
    GetProductUseCase getProductUseCase;

    @Autowired
    GetDiscountUseCase getDiscountUseCase;

    @Autowired
    LoginUseCase loginUseCase;

    @Autowired
    AddUserUseCase addUserUseCase;


    @PostMapping(value= "/Login")
    public ResponseEntity<LoginUseCaseOutput> login(@RequestBody LoginUseCaseInput requestBody){
        System.out.println("--------server----------");
        LoginUseCaseInput input = new LoginUseCaseInput();
        LoginUseCaseOutput output = new LoginUseCaseOutput();
        input.setUsername(requestBody.getUsername());
        input.setPassword(requestBody.getPassword());
        try {
            this.loginUseCase.execute(input, output);
        } catch (LoginErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value= "/product")
    public ResponseEntity<GetProductUseCaseOutput> getAllProduct() {        
        System.out.println("--------server----------");
        GetProductUseCaseOutput output = new GetProductUseCaseOutput();
        try {
            this.getProductUseCase.execute(output);
        } catch (GetProductErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }


    @GetMapping(value= "/discount")
    public ResponseEntity<GetDiscountUseCaseOutput> getAllDiscount() {
        GetDiscountUseCaseInput input = new GetDiscountUseCaseInput();
        GetDiscountUseCaseOutput output = new GetDiscountUseCaseOutput();
        //------Request body send current date
        input.setCurrentDate("2021/01/07");
        try {
            this.getDiscountUseCase.execute(input, output);
        } catch (GetDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value= "/seller/discount")
    public ResponseEntity<GetDiscountUseCaseOutput> getSellerDiscount() {
        GetDiscountUseCaseInput input = new GetDiscountUseCaseInput();
        GetDiscountUseCaseOutput output = new GetDiscountUseCaseOutput();
        //------Request body send current date
        input.setCurrentDate("2021/01/07");
        try {
            this.getDiscountUseCase.sellerExecute(input, output);
        } catch (GetDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value= "/rate")
    public ResponseEntity<GetRateUseCaseOutput> getAllRate(@RequestBody GetRateUseCaseInput requestBody){
        GetRateUseCaseInput input = new GetRateUseCaseInput();
        GetRateUseCaseOutput output = new GetRateUseCaseOutput();
        try {
            this.getRateUseCase.execute(input, output);
        } catch (GetRateErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}