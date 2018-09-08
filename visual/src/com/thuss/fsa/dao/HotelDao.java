package com.thuss.fsa.dao;

import java.util.List;

import com.thuss.fsa.item.HotHotelItem;
import com.thuss.fsa.item.HotelItem;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.model.Hotel;

public interface HotelDao {

	public void add(Hotel u);

	public void update(Hotel u);

	public void delete(Hotel u);

	public Hotel getById(long id);
	
	public List<Hotel> getAll();

	public List<HotHotelItem> getHotHotels();

	public List<IncomeItem> getIncomeList(long hotelId);

	public List<Hotel> getSimiliarHotels(long hotelId);

	public int searchRowCount(String keyword);

	public List<HotelItem> searchForPage(String keyword, int offset, int length);

	List<IncomeItem> getHistoryIncome(long hotelId);
}
