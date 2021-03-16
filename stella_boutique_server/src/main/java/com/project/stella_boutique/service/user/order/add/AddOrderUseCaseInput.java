package com.project.stella_boutique.service.user.order.add;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.time.LocalDateTime;    


public class AddOrderUseCaseInput {
    private Date orderDate;
    private int status;
    private int discountID;
	private int userID;
	private List<String> itemList;


	public int getDiscountID() {
		return this.discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public List<String> getItemList() {
		return this.itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}

	public int getItemListLength() {
		return this.itemList.size();
	}

	public String getItemNo(int index) {
		return this.itemList.get(index);
	}

    public void AddOrderUseCaseInput(){
		this.status = 0;
    }

	public int getStatus() {
		return this.status;
	}

	public void setStatus() {
		this.status = status;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

    public static final String DATE_FORMAT = "yyyy/MM/dd";
    
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String ordeDate) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            this.orderDate = dateFormat.parse(ordeDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid Current Date: " + ordeDate);
        }
    }

    public String getOrderDateString() {
		return ToString(this.orderDate);
	}

	public String ToString(Date date) {
        return (new SimpleDateFormat(this.DATE_FORMAT)).format(date);
    }
}