package com.project.stella_boutique.rest;

import com.project.stella_boutique.service.seller.discount.add.AddSellerDiscountUseCase;
import com.project.stella_boutique.service.seller.discount.add.AddSellerDiscountUseCaseInput;
import com.project.stella_boutique.service.seller.discount.add.AddSellerDiscountUseCaseOutput;
import com.project.stella_boutique.service.seller.discount.get.GetSellerDiscountUseCase;
import com.project.stella_boutique.service.seller.discount.get.GetSellerDiscountUseCaseOutput;
import com.project.stella_boutique.service.seller.discount.remove.RemoveSellerDiscountUseCase;
import com.project.stella_boutique.service.seller.discount.remove.RemoveSellerDiscountUseCaseInput;
import com.project.stella_boutique.service.seller.discount.remove.RemoveSellerDiscountUseCaseOutput;
import com.project.stella_boutique.service.seller.discount.update.UpdateSellerDiscountUseCase;
import com.project.stella_boutique.service.seller.discount.update.UpdateSellerDiscountUseCaseInput;
import com.project.stella_boutique.service.seller.discount.update.UpdateSellerDiscountUseCaseOutput;
import com.project.stella_boutique.service.seller.order.get.GetSellerOrderUseCase;
import com.project.stella_boutique.service.seller.order.get.GetSellerOrderUseCaseOutput;
import com.project.stella_boutique.service.seller.order.update.UpdateSellerOrderUseCase;
import com.project.stella_boutique.service.seller.order.update.UpdateSellerOrderUseCaseInput;
import com.project.stella_boutique.service.seller.order.update.UpdateSellerOrderUseCaseOutput;
import com.project.stella_boutique.service.seller.product.add.AddSellerProductUseCase;
import com.project.stella_boutique.service.seller.product.add.AddSellerProductUseCaseInput;
import com.project.stella_boutique.service.seller.product.add.AddSellerProductUseCaseOutput;
import com.project.stella_boutique.service.seller.product.get.GetSellerProductUseCase;
import com.project.stella_boutique.service.seller.product.get.GetSellerProductUseCaseOutput;
import com.project.stella_boutique.service.seller.product.remove.RemoveSellerProductUseCase;
import com.project.stella_boutique.service.seller.product.remove.RemoveSellerProductUseCaseInput;
import com.project.stella_boutique.service.seller.product.remove.RemoveSellerProductUseCaseOutput;
import com.project.stella_boutique.service.seller.product.update.UpdateSellerProductUseCase;
import com.project.stella_boutique.service.seller.product.update.UpdateSellerProductUseCaseInput;
import com.project.stella_boutique.service.seller.product.update.UpdateSellerProductUseCaseOutput;
import com.project.stella_boutique.service.management.user.*;
import com.project.stella_boutique.service.exception.AddDiscountErrorException;
import com.project.stella_boutique.service.exception.AddProductErrorException;
import com.project.stella_boutique.service.exception.GetDiscountErrorException;
import com.project.stella_boutique.service.exception.GetProductErrorException;
import com.project.stella_boutique.service.exception.GetOrderErrorException;
import com.project.stella_boutique.service.exception.RemoveDiscountErrorException;
import com.project.stella_boutique.service.exception.RemoveProductErrorException;
import com.project.stella_boutique.service.exception.UpdateDiscountErrorException;
import com.project.stella_boutique.service.exception.UpdateOrderErrorException;
import com.project.stella_boutique.service.exception.UpdateProductErrorException;
import com.project.stella_boutique.service.exception.LoginErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
public class SellerRestAdapter {
    @Autowired
    AddSellerDiscountUseCase addSellerDiscountUseCase;

    @Autowired
    GetSellerDiscountUseCase getSellerDiscountUseCase;

    @Autowired
    RemoveSellerDiscountUseCase removeSellerDiscountUseCase;
    
    @Autowired
    UpdateSellerDiscountUseCase updateSellerDiscountUseCase;

    @Autowired
    GetSellerOrderUseCase getSellerOrderUseCase;

    @Autowired
    UpdateSellerOrderUseCase updateSellerOrderUseCase;

    @Autowired
    AddSellerProductUseCase addSellerProductUseCase;

    @Autowired
    GetSellerProductUseCase getSellerProductUseCase;

    @Autowired
    RemoveSellerProductUseCase removeSellerProductUseCase;

    @Autowired
    UpdateSellerProductUseCase updateSellerProductUseCase;

    @Autowired
    GetUserUseCase getUserUseCase;
    
    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- Seller Discount --------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------
    @PostMapping(value = "/add/discount")
    public ResponseEntity<AddSellerDiscountUseCaseOutput> addDiscount(@RequestBody AddSellerDiscountUseCaseInput requestBody) {
        System.out.println("~~~~disc");
        
        AddSellerDiscountUseCaseInput input = new AddSellerDiscountUseCaseInput(requestBody.getValue(),requestBody.getCode(),requestBody.getName(),requestBody.getStartDateString(),requestBody.getEndDateString());
        AddSellerDiscountUseCaseOutput output = new AddSellerDiscountUseCaseOutput();
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------

        try {
            this.addSellerDiscountUseCase.execute(input, output);
        } catch (AddDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value = "/get/discount")
    public ResponseEntity<GetSellerDiscountUseCaseOutput> getAllDiscount() {
        GetSellerDiscountUseCaseOutput output = new GetSellerDiscountUseCaseOutput();
        try {
            this.getSellerDiscountUseCase.execute(output);
        } catch (GetDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PostMapping(value = "/remove/discount")
    public ResponseEntity<RemoveSellerDiscountUseCaseOutput> removeDiscount(@RequestBody RemoveSellerDiscountUseCaseInput requestBody) {
        RemoveSellerDiscountUseCaseInput input = new RemoveSellerDiscountUseCaseInput();
        RemoveSellerDiscountUseCaseOutput output = new RemoveSellerDiscountUseCaseOutput();
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.removeSellerDiscountUseCase.execute(input, output);
        } catch (RemoveDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PostMapping(value = "/update/discount")
    public ResponseEntity<UpdateSellerDiscountUseCaseOutput> updateDiscount(@RequestBody UpdateSellerDiscountUseCaseInput requestBody) {
        UpdateSellerDiscountUseCaseInput input = new UpdateSellerDiscountUseCaseInput();
        UpdateSellerDiscountUseCaseOutput output = new UpdateSellerDiscountUseCaseOutput();
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.updateSellerDiscountUseCase.execute(input, output);
        } catch (UpdateDiscountErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- Seller Order -----------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------
    @GetMapping(value = "/get/order")
    public ResponseEntity<GetSellerOrderUseCaseOutput> getOrder() {
        System.out.println("getting order list");
        GetSellerOrderUseCaseOutput output = new GetSellerOrderUseCaseOutput();
        System.out.println("orderr");
        try {
            this.getSellerOrderUseCase.execute(output);
            for(int i=0;i<output.getOrderList().size();i++){
                for(int j=0;j<output.getOrderList().get(i).getItemList().size();j++){
                    System.out.println(output.getOrderList().get(i).getItemList().get(j).getName());
                }
            }
        } catch (GetOrderErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PostMapping(value = "/update/order")
    public ResponseEntity<UpdateSellerOrderUseCaseOutput> updateOrder(@RequestBody UpdateSellerOrderUseCaseInput requestBody) {
        UpdateSellerOrderUseCaseInput input = new UpdateSellerOrderUseCaseInput();
        UpdateSellerOrderUseCaseOutput output = new UpdateSellerOrderUseCaseOutput();
        input.setOrderID(requestBody.getOrderID());
        input.setStatus(requestBody.getStatus());
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.updateSellerOrderUseCase.execute(input, output);
        } catch (UpdateOrderErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- Seller Product ---------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------
    @PostMapping(value = "/add/product")
    public ResponseEntity<AddSellerProductUseCaseOutput> addProduct(@RequestBody AddSellerProductUseCaseInput requestBody) {
        AddSellerProductUseCaseInput input = new AddSellerProductUseCaseInput(requestBody.getName(),requestBody.getQuantity(),requestBody.getCategory(),requestBody.getSize(),requestBody.getPrice(),requestBody.getDescription(),requestBody.getPictureURL());
        AddSellerProductUseCaseOutput output = new AddSellerProductUseCaseOutput();
        
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.addSellerProductUseCase.execute(input, output);
        } catch (AddProductErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value = "/get/product")
    public ResponseEntity<GetSellerProductUseCaseOutput> getProduct() {
        GetSellerProductUseCaseOutput output = new GetSellerProductUseCaseOutput();
        try {
            this.getSellerProductUseCase.execute(output);
        } catch (GetProductErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PostMapping(value = "/remove/product")
    public ResponseEntity<RemoveSellerProductUseCaseOutput> removeProduct(@RequestBody RemoveSellerProductUseCaseInput requestBody) {
        RemoveSellerProductUseCaseInput input = new RemoveSellerProductUseCaseInput();
        RemoveSellerProductUseCaseOutput output = new RemoveSellerProductUseCaseOutput();
        input.setItemID(requestBody.getItemID());
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.removeSellerProductUseCase.execute(input, output);
        } catch (RemoveProductErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @PostMapping(value = "/update/product")
    public ResponseEntity<UpdateSellerProductUseCaseOutput> updateProduct(@RequestBody UpdateSellerProductUseCaseInput requestBody) {
        UpdateSellerProductUseCaseInput input = new UpdateSellerProductUseCaseInput();
        UpdateSellerProductUseCaseOutput output = new UpdateSellerProductUseCaseOutput();
        input.setItemID(requestBody.getItemID());
        input.setName(requestBody.getName());
        input.setDescription(requestBody.getDescription());
        input.setPrice(requestBody.getPrice());
        //------------------------------Unfinished------------------------------
        //----------------------------------------------------------------------
        try {
            this.updateSellerProductUseCase.execute(input, output);
        } catch (UpdateProductErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value = "/get/user")
    public ResponseEntity<GetUserUseCaseOutput> getUser() {
        GetUserUseCaseOutput output = new GetUserUseCaseOutput();
        try {
            this.getUserUseCase.execute(output);
        } catch (LoginErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(output);
        }
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}