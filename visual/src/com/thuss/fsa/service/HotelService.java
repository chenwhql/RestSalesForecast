package com.thuss.fsa.service;

import java.util.List;

import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.HotHotelItem;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.item.SimiliarIncomeList;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.util.Page;

public interface HotelService {

	public void add(Hotel u);

	public void update(Hotel u);

	public void delete(Hotel u);

	public List<Hotel> getAll();
	
	public Hotel getById(long id);
	
	public List<Hotel> searchHotel(String keyword);
	
	public List<HotHotelItem> getHotHotels();

	public List<IncomeItem> getIncomeList(long hotelId);

	public List<Hotel> getSimiliarHotels(long hotelId);

	public List<SimiliarIncomeList> getSimiliarIncomes(Hotel h,List<Hotel> similiarHotels);

	public List<HotFoodItem> getHotFoods(long hotelId);

	public List<HotFoodItem> getPoorFoods(long hotelId);

	public Page searchForPage(String keyword, int currentPage, int pageSize);

	List<IncomeItem> getHistoryIncome(long hotelId);

}
