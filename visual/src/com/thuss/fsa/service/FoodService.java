package com.thuss.fsa.service;

import java.util.List;

import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.SaleItem;
import com.thuss.fsa.item.SimiliarSaleList;
import com.thuss.fsa.model.Food;
import com.thuss.fsa.util.Page;

public interface FoodService {

	public void add(Food u);

	public void update(Food u);

	public void delete(Food u);

	public List<Food> getAll();
	
	public Food getById(long id);
	
	public Page searchForPage(String keyword, int currentPage, int pageSize);
	
	public List<HotFoodItem> getHotFoods();

	public List<SaleItem> getSalesList(long foodId);

	public List<Food> getSimiliarFoods(Food food);

	public List<SimiliarSaleList> getSimiliarSales(Food food,
			List<Food> similiarFoods);

	List<SaleItem> getSSalesList(long foodId);

	public int getRecommendPrice(Food food);

	public List<Food> getGroupFoods(Food food);
	
}
