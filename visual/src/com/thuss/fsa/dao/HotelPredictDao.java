package com.thuss.fsa.dao;

import java.util.List;

import com.thuss.fsa.model.HotelPredict;

public interface HotelPredictDao {

	public void add(HotelPredict u);

	public void update(HotelPredict u);

	public void delete(HotelPredict u);

	public HotelPredict getById(long id);
	
	List<HotelPredict> getAll();
}
