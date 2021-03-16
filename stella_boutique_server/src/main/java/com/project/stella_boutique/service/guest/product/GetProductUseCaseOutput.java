package com.project.stella_boutique.service.guest.product;

import java.util.List;

import com.project.stella_boutique.model.item.Item;

public class GetProductUseCaseOutput {
    private List<Item> productList;

    public void setProductList(List<Item> productList) {
        this.productList = productList;
    }

    public List<Item> getProductList() {
        return this.productList;
    }

}