package com.project.stella_boutique.service.seller.product.update;

public class UpdateSellerProductUseCaseInput{
    private int itemID;
    private String name;
    private int price;
    private String description;

	public UpdateSellerProductUseCaseInput(){
		
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
    }
    

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
}