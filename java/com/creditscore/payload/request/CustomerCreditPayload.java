package com.creditscore.payload.request;

import java.sql.Date;

public class CustomerCreditPayload {

	private String ssnNumber;
	
	private Double loanAmout;
	
	private Double annualIncome;
	
	private Date createdDate;
	

	public String getSsnNumber() {
		return ssnNumber;
	}

	public void setSsnNumber(String ssnNumber) {
		this.ssnNumber = ssnNumber;
	}

	public Double getLoanAmout() {
		return loanAmout;
	}

	public void setLoanAmout(Double loanAmout) {
		this.loanAmout = loanAmout;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
