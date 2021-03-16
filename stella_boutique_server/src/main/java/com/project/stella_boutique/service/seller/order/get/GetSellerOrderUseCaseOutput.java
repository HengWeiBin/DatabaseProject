package com.project.stella_boutique.service.seller.order.get;

import java.util.List;

import com.project.stella_boutique.model.order.Order;

public class GetSellerOrderUseCaseOutput {
    private List<Order> orderList;

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }
}