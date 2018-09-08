package com.thuss.fsa.dao;

import java.util.List;

import com.thuss.fsa.item.FoodItem;
import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.SaleItem;
import com.thuss.fsa.model.Food;

public interface FoodDao {

	public void add(Food u);

	public void update(Food u);

	public void delete(Food u);

	public Food getById(long id);
	
	public List<Food> getAll();

	public int searchRowCount(String keyword);
	
	public List<FoodItem> searchForPage(String keyword,int offset,int length);

	public List<HotFoodItem> getHotFoods();

	public List<HotFoodItem> getHotFoods(long hotelId);

	public List<HotFoodItem> getPoorFoods(long hotelId);

	public List<SaleItem> getSalesList(long foodId);

	public List<Food> getSimiliarFoods(Food food);

	List<SaleItem> getSSalesList(long foodId);

	public List<Food> getTop10(Food food);

	public List<Food> getGroupFoods(Food food);
}
