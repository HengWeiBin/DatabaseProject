package com.project.stella_boutique.model.item;

public class ItemList {
    
    private int itemID;
    private int orderID;
    private int amount;

    public ItemList(int itemID, int userID, int amount) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.amount = amount;
    }

    public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

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
    
}