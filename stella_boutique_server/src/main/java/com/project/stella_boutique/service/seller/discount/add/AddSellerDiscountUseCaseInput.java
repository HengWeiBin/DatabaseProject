package com.project.stella_boutique.service.seller.discount.add;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSellerDiscountUseCaseInput {
    private Float value;
    private String name;
    private Date startDate;
	private Date endDate;
    private String code;
    
    private final String DATE_FORMAT = "yyyy/MM/dd";

    public AddSellerDiscountUseCaseInput(){}

	public AddSellerDiscountUseCaseInput( 
					Float value, 
					String code, 
					String name, 
					String startDate, 
					String endDate) {
		this.value = value;
		this.name = name;
		this.code = code;
		final SimpleDateFormat dateFormat = new SimpleDateFormat(this.DATE_FORMAT);
        try {
            this.startDate = dateFormat.parse(startDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid Start Date: " + startDate);
        }
        try {
            this.endDate = dateFormat.parse(endDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid End Date format: " + endDate);
        }
	}
	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public String getStartDateString() {
		return ToString(this.startDate);
	}


	public String getEndDateString() {
		return ToString(this.endDate);
	}


	public String ToString(Date date) {
        return (new SimpleDateFormat(this.DATE_FORMAT)).format(date);
	}
	public void setStartDate(String startDate) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(this.DATE_FORMAT);
		try {
            this.startDate = dateFormat.parse(startDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid Start Date: " + startDate);
        }
	}

	public Date getEndDate() {
		return this.endDate;
	}
	public void setEndDate(String endDate) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(this.DATE_FORMAT);
		try {
            this.endDate = dateFormat.parse(endDate);
        } catch (final ParseException e) {
            throw new IllegalArgumentException("Invalid End Date format: " + endDate);
        }
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}