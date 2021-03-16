package com.project.stella_boutique.model.rate;

public class Rate {
    
    private int rateID;
    private int itemID;
    private int userID;
    private String comment;
    private int rate;

    public Rate(int rateID, int itemID, int userID, String comment, int rate) {
        this.rateID = rateID;
        this.itemID = itemID;
        this.userID = userID;
        this.comment = comment;
        this.rate = rate;
    }

	public int getRateID() {
		return this.rateID;
	}

	public void setRateID(int rateID) {
		this.rateID = rateID;
	}

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}