package com.project.stella_boutique.service.guest.discount;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class GetDiscountUseCaseInput {
    private Date currentDate;
    public static final String DATE_FORMAT = "yyyy/MM/dd";
    
	public Date getCurrentDate() {
		return this.currentDate;
	}

	public void setCurrentDate(String currentDate) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            this.currentDate = dateFormat.parse(currentDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid Current Date: " + currentDate);
        }    
    }
}