package com.project.stella_boutique.service.user.like.remove;

public class RemoveLikeUseCaseInput {
    private int userID;
    private int itemID;

    public RemoveLikeUseCaseInput(){
        
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