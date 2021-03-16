package com.project.stella_boutique.service.user.like.add;

public class AddLikeUseCaseInput {
    private int userID;
    private int itemID;

    public AddLikeUseCaseInput(){
        
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

}