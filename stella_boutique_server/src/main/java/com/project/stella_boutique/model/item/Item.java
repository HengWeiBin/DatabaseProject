package com.project.stella_boutique.model.item;

import java.util.List;
import java.util.ArrayList;

public class Item {
    private int itemID;
    private int quantity;
    private String category;
    private String size;
    private Float price;
    private String description;
    private String pictureURL;
	private String name;
	private List<List<String>> ratings;
	private int buyAmount;

	public Item(int itemID, String name, int quantity, String category, String size ,Float price, String description, String pictureURL){
		this.itemID = itemID;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
		this.size = size;
		this.price = price;
		this.description = description;
		this.pictureURL = pictureURL;
		this.ratings = new ArrayList<List<String>>();
	}

	public Item() {

	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
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

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
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
    
	public List<List<String>> getRatings() {
		return this.ratings;
	}

	public void setRatings(String comment, int rate) {
		List<String> rating = new ArrayList<String>();
		rating.add(comment);
		rating.add(Integer.toString(rate));
		this.ratings.add(rating);
	}

	public int getBuyAmount() {
		return this.buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	
    
}
