package com.project.stella_boutique.service.user.order.history;
import com.project.stella_boutique.model.order.Order;
import java.util.List;
import java.util.ArrayList;
public class HistoryOrderUseCaseOutput {
    private List<Order> orderList;

	public List<Order> getOrderList() {
		return this.orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}