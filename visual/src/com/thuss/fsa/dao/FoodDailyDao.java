package com.thuss.fsa.dao;

import java.util.List;

import com.thuss.fsa.model.FoodDaily;

public interface FoodDailyDao {

	public void add(FoodDaily u);

	public void update(FoodDaily u);

	public void delete(FoodDaily u);

	public FoodDaily getById(long id);
	
	List<FoodDaily> getAll();
}
