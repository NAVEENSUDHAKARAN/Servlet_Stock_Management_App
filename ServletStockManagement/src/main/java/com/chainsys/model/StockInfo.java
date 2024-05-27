package com.chainsys.model;

import javax.servlet.RequestDispatcher;

public class StockInfo {

	String adminName;
	int password, maxRange, minRange;
	String productName, stockedDate;
	int id, numberOfStock;
	double costPrice;
	
	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public int getMinRange() {
		return minRange;
	}

	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStockedDate() {
		return stockedDate;
	}

	public void setStockedDate(String stockedDate) {
		this.stockedDate = stockedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(int numberOfStock) {
		this.numberOfStock = numberOfStock;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	
	
	@Override
	public String toString() {
		return "StockPojo [productName=" + productName + ", stockedDate=" + stockedDate + ", id=" + id
				+ ", numberOfStock=" + numberOfStock + ", costPrice=" + costPrice + "]";
	}

}