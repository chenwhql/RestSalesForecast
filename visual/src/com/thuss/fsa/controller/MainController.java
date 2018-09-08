package com.thuss.fsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.HotHotelItem;
import com.thuss.fsa.model.Food;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.service.FoodService;
import com.thuss.fsa.service.HotelService;
import com.thuss.fsa.util.Page;

@Controller
public class MainController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private HotelService hotelService;
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHotHotels(ModelMap modal){
		List<HotHotelItem> hotelList = hotelService.getHotHotels();
		modal.addAttribute("hotHotels",hotelList);
		List<HotFoodItem> foodList = foodService.getHotFoods();
		modal.addAttribute("hotFoods",foodList);
		return "home";
	}
    
    
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchFood(ModelMap modal,@RequestParam String searchType,@RequestParam String keyword,@RequestParam(required=false) String pageNo)
	{
		System.out.println("search");
		if(pageNo == null)
		{
			pageNo="1";
		}
		if(searchType.equals("餐厅"))
		{
			Page page = hotelService.searchForPage(keyword, Integer.valueOf(pageNo),20);
			page.setSearchType(searchType);
			modal.addAttribute("page",page);
			return "hotelResults";
		}
		else
		{
			Page page = foodService.searchForPage(keyword, Integer.valueOf(pageNo),20);
			page.setSearchType(searchType);
			modal.addAttribute("page",page);
			return "foodResults";
		}
	}
	
}
