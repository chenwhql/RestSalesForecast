package com.thuss.fsa.item;

import java.util.List;

public class SimiliarSaleList {
	private String foodName;
	private String hotelName;
	private List<SaleItem> sales;
	
	public SimiliarSaleList() {
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public List<SaleItem> getSales() {
		return sales;
	}
	public void setSales(List<SaleItem> sales) {
		this.sales = sales;
	}
	
	
	
	
}
