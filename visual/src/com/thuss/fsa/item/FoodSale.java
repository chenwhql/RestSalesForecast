package com.thuss.fsa.item;

import java.util.List;

public class FoodSale {
	private String foodName;
	private String hotelName;
	private List<Integer> sales;
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
	public List<Integer> getSales() {
		return sales;
	}
	public void setSales(List<Integer> sales) {
		this.sales = sales;
	}
	
	

}
