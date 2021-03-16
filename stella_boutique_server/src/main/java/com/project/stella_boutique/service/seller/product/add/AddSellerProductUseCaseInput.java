package com.project.stella_boutique.service.seller.product.add;

public class AddSellerProductUseCaseInput {
    private int quantity;
    private String category;
    private String size;
    private int price;
    private String description;
    private String pictureURL;
    private String name;

	public AddSellerProductUseCaseInput(String name, int quantity, String category, String size ,int price, String description, String pictureURL){
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.size = size;
		this.price = price;
		this.description = description;
		this.pictureURL = pictureURL;
	}
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureURL() {
		return this.pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}