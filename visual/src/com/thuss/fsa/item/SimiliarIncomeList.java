package com.thuss.fsa.item;

import java.util.List;

public class SimiliarIncomeList {
	private String hotelName;
	private List<IncomeItem> incomes;
	
	public SimiliarIncomeList() {
		super();
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public List<IncomeItem> getIncomes() {
		return incomes;
	}
	public void setIncomes(List<IncomeItem> incomes) {
		this.incomes = incomes;
	}
	
}
