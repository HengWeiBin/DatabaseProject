package com.project.stella_boutique.model.order;

import java.util.List;
import java.util.ArrayList;
import com.project.stella_boutique.model.item.Item;

public class Order {

    private int orderID;
    private int status;
    private String orderDate;
    private int discountID;
	private int userID;
	private List<Item> itemList;
	private int totalPrice;
	private double value;

	public Order(int orderID, int status, String orderDate, int discountID, int userID){
		this.orderID = orderID;
		this.status = status;
		this.orderDate = orderDate;
		this.discountID = discountID;
		this.userID = userID;
		this.itemList = new ArrayList<Item>();
		this.totalPrice = 0;
	}

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

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getDiscountID() {
		return this.discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

     
	public List<Item> getItemList() {
		return this.itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void addItemToList(Item item) {
		// List<Object> order = new ArrayList<Object>();
		// order.add(item);
		// order.add(amount);
		// this.itemList.add(order);
		System.out.println("add " + item.getName() + " to list");
		this.itemList.add(item);
	}

	public double getTotalPrice() {
		double sum = 0;
		for(int i=0;i<this.itemList.size();i++){
			sum += ((double)this.itemList.get(i).getPrice() * this.itemList.get(i).getBuyAmount());
		}
		if(this.discountID!=1){
			sum = (double)sum*value;
			return sum;
		}else{
			return sum;
		}
		
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}