package com.project.stella_boutique.model.discount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Discount {

    private int discountID;
    private Float value;
    private String discountName;
    private Date startDate;
	private Date endDate;
	private String code;

	public static final String DATE_FORMAT = "yyyy/MM/dd";

	public Discount(int discountID, 
					Float value, 
					String discountName, 
					String startDate, 
					String endDate, 
					String code) {
		this.discountID = discountID;
		this.value = value;
		this.discountName = discountName;
		this.code = code;
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
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

	public int getDiscountID() {
		return this.discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public Float getValue() {
		return this.value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
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
		final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
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
	
	public String getStartDateString() {
		return ToString(this.startDate);
	}


	public String getEndDateString() {
		return ToString(this.endDate);
	}

	public String ToString(Date date) {
        return (new SimpleDateFormat(this.DATE_FORMAT)).format(date);
	}

}