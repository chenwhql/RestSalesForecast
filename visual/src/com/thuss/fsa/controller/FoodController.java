package com.thuss.fsa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thuss.fsa.item.FoodSale;
import com.thuss.fsa.item.HotelIncome;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.item.SaleItem;
import com.thuss.fsa.item.SimiliarIncomeList;
import com.thuss.fsa.item.SimiliarSaleList;
import com.thuss.fsa.model.Food;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.service.FoodService;
import com.thuss.fsa.service.HotelService;

@Controller
public class FoodController {

	@Autowired
	private FoodService foodService;
	@Autowired
	private HotelService hotelService;
	
    @RequestMapping(value = "/foodInfo", method = RequestMethod.GET)
    public String foodInfo(ModelMap model,@RequestParam long foodId) {
    	//餐厅信息
    	Food food = foodService.getById(foodId);
    	model.addAttribute("food",food);
    	Hotel hotel = hotelService.getById(food.getHotelId());
    	model.addAttribute("hotel",hotel);
    	//推荐定价
    	int recommendPrice = foodService.getRecommendPrice(food);
    	model.addAttribute("recommendPrice", recommendPrice);
    	//搭配菜品推荐
    	List<Food> groupFoods = foodService.getGroupFoods(food);
    	model.addAttribute("groupFoods", groupFoods);
        return "foodInfo";
    }	
    
    @RequestMapping(value = "/foodsales", method = RequestMethod.GET)
    @ResponseBody
    public FoodSale foodsales(ModelMap model,@RequestParam long foodId) {
    	//历史销量和预测销量
    	Food food = foodService.getById(foodId);
    	List<SaleItem> salesList = foodService.getSalesList(foodId);
    	Hotel hotel = hotelService.getById(food.getHotelId());
    	FoodSale sale = new FoodSale();
    	
    	List<Integer> list = new ArrayList<Integer>();
    	for(SaleItem s:salesList)
    	{
    		list.add(s.getSoldNum());
    	}
    	sale.setFoodName(food.getFoodName());
    	sale.setHotelName(hotel.getHotelName());
    	sale.setSales(list);
        return sale;
    }
    @RequestMapping(value = "/similiarSales", method = RequestMethod.GET)
    @ResponseBody
    public List<FoodSale> similiarIncomes(ModelMap model,@RequestParam long foodId) {
    	
    	Food food = foodService.getById(foodId);
    	//热销同类菜品
    	List<Food> similiarFoods = foodService.getSimiliarFoods(food);
    	//热销同类菜品销量对比
    	List<SimiliarSaleList> similiarSales = foodService.getSimiliarSales(food,similiarFoods);
    	
    	List<FoodSale> fSales = new ArrayList<FoodSale>();
    	
    	for(SimiliarSaleList lItem:similiarSales)
    	{
    		List<Integer>  sales = new ArrayList<Integer>();
    		FoodSale fSale = new FoodSale();
        	for(SaleItem item:lItem.getSales())
        	{
        		sales.add(item.getSoldNum());
        	}
        	fSale.setHotelName(lItem.getHotelName());
        	fSale.setFoodName(lItem.getFoodName());
        	fSale.setSales(sales);
        	fSales.add(fSale);
    	}
        return fSales;
    }	
}
