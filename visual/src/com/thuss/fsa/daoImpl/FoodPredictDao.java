package com.thuss.fsa.daoImpl;

import java.util.List;

import com.thuss.fsa.model.FoodPredict;

public interface FoodPredictDao {

	public void add(FoodPredict u);

	public void update(FoodPredict u);

	public void delete(FoodPredict u);

	public FoodPredict getById(long id);
	
	List<FoodPredict> getAll();
}
