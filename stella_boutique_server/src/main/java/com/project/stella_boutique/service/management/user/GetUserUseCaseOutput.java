package com.project.stella_boutique.service.management.user;
import com.project.stella_boutique.model.user.User;
import java.util.List;

public class GetUserUseCaseOutput {
    private List<User> userList;

    public GetUserUseCaseOutput(){
        
    }
	public List<User> getUserList() {
		return this.userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}