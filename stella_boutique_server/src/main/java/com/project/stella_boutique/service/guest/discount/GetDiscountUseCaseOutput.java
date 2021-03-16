package com.project.stella_boutique.service.guest.discount;

import java.util.List;

import com.project.stella_boutique.model.discount.Discount;

public class GetDiscountUseCaseOutput {
    private List<Discount> discountList;

    public void setDiscountList(List<Discount> discountList){
        this.discountList = discountList;
    }

    public List<Discount> getDiscountList() {
        return this.discountList;
    }
}