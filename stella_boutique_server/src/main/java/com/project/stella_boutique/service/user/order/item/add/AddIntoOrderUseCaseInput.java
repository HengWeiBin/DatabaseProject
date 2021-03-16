package com.project.stella_boutique.service.user.order.item.add;

import java.util.Date;
import java.util.List;

public class AddIntoOrderUseCaseInput {
    // private List<int> itemList;
    private int orderID;
    private int amount;

    public void AddIntoOrderUseCaseInput(){
        this.amount=1;
    }

	// public List<int> getItemList() {
	// 	return this.itemList;
	// }

	// public void setItemList(List<int> itemList) {
	// 	this.itemList = itemList;
	// }

    public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
    }

    public void addAmount() {
		this.amount+=1;
	}

}