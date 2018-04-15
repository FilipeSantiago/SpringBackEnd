package com.eureka.client.consumer;

import java.math.BigDecimal;

public class EurekaClientModel {

	private String fastPassId;
	private String customerFullName;
	private String fastPassPhone;
	private BigDecimal currentBalance;
	
	public EurekaClientModel() {}
	
	public EurekaClientModel (String fastPassId, String customerFullName, String fastPassPhone, BigDecimal currentBalance) {
		this.fastPassId = fastPassId;
		this.customerFullName = customerFullName;
		this.fastPassPhone = fastPassPhone;
		this.currentBalance = currentBalance;
	}
	
	public String getFastPassId() {
		return fastPassId;
	}
	public void setFastPassId(String fastPassId) {
		this.fastPassId = fastPassId;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getFastPassPhone() {
		return fastPassPhone;
	}
	public void setFastPassPhone(String fastPassPhone) {
		this.fastPassPhone = fastPassPhone;
	}
}
