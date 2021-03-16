package com.project.stella_boutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.stella_boutique.service.SellerService;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import com.project.stella_boutique.model.discount.Discount;
import com.project.stella_boutique.model.item.*;
import com.project.stella_boutique.model.order.Order;
import com.project.stella_boutique.model.user.User;

@SpringBootApplication
public class StellaBoutiqueApplication {
	public static void main(String[] args) {
		SpringApplication.run(StellaBoutiqueApplication.class, args);
		
		SellerService sellerService = new SellerService();
		// -------------------------------------
		// List<Item> productList = sellerService.GetProduct();
		// for(Item product:productList){
		// 	System.out.println(product.getName());
		// 	if(product.getRatings().size()>1){
		// 		for(int i=0;i<product.getRatings().size();i++){
		// 			for(int j=0;j<2;j++){
		// 				System.out.println(product.getRatings().get(i).get(j));
		// 			}
		// 		}
		// 	}
		// 	else{
		// 		System.out.println("no rating");
		// 	}
		// 	System.out.println("-------------------");
		// }
		// ---------------------------------
		// List<Discount> discountList = sellerService.GetDiscount("2020/12/24");
		// for(Discount disc:discountList){
		// 	System.out.println(disc.getDiscountName());
		// 	System.out.println("-------------------");
		// }
		
	}

}
