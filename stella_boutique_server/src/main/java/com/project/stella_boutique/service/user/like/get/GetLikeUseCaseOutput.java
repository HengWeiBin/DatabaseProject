package com.project.stella_boutique.service.user.like.get;
import java.util.List;
import java.util.ArrayList;

public class GetLikeUseCaseOutput {
    private List<Integer> likeList;

    public GetLikeUseCaseOutput(){
        this.likeList = new ArrayList<>();
    }
	public List<Integer> getLikeList() {
		return this.likeList;
	}

	public void setLikeList(List<Integer> likeList) {
		this.likeList = likeList;
	}
}