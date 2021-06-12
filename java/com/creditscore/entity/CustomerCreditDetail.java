package com.creditscore.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")

public class CustomerCreditDetail {

	@Id
	@Column(name="SSN")
	private String ssnNumber;
	
	@Column(name="LOAN_AMOUNT")
	private Double loanAmout;
	
	@Column(name="Current_Annual_Income")
	private Double annualIncome;
	
	@Column(name="Created_Ts")
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

	@Override
	public String toString() {
		return "CustomerCreditDetail [ssnNumber=" + ssnNumber + ", loanAmout=" + loanAmout + ", annualIncome="
				+ annualIncome + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
}
