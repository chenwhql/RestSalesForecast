package com.thuss.fsa.dao;

import java.util.List;

import com.thuss.fsa.model.HotelDaily;

public interface HotelDailyDao {

	public void add(HotelDaily u);

	public void update(HotelDaily u);

	public void delete(HotelDaily u);

	public HotelDaily getById(long id);
	
	List<HotelDaily> getAll();
}
