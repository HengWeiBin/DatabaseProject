package com.project.stella_boutique.service.guest.rate;

import java.util.List;

import com.project.stella_boutique.model.rate.Rate;

public class GetRateUseCaseOutput {
    private List<Rate> rateList;

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    public List<Rate> getRateList() {
        return rateList;
    }
}