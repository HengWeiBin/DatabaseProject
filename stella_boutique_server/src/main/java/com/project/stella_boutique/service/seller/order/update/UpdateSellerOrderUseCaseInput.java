package com.project.stella_boutique.service.seller.order.update;

public class UpdateSellerOrderUseCaseInput{
    private int orderID;
    private int status;
    
	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
}