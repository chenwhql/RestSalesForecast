package com.thuss.fsa.item;

import java.util.List;

public class HotelIncome {
	private String hotelName;
	private String startDate;
	private List<Double> incomes;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public List<Double> getIncomes() {
		return incomes;
	}
	public void setIncomes(List<Double> incomes) {
		this.incomes = incomes;
	}
}
