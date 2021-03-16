package com.project.stella_boutique.service.seller.discount.get;

import java.util.List;

import com.project.stella_boutique.model.discount.Discount;

public class GetSellerDiscountUseCaseOutput {
    private List<Discount> discountList;

    public void setDiscountList(List<Discount> discountList){
        this.discountList = discountList;
    }

    public List<Discount> getDiscountList() {
        return this.discountList;
    }
}