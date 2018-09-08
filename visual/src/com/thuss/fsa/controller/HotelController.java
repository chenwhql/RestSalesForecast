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

import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.HotelIncome;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.item.SimiliarIncomeList;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.service.FoodService;
import com.thuss.fsa.service.HotelService;

@Controller
public class HotelController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private HotelService hotelService;
	
    @RequestMapping(value = "/hotelInfo", method = RequestMethod.GET)
    public String hotelInfo(ModelMap model,@RequestParam long hotelId) {
    	//餐厅信息
    	Hotel hotel = hotelService.getById(hotelId);
    	model.addAttribute("hotel",hotel);
    	
    	//热销菜品
    	List<HotFoodItem> hotFoods = hotelService.getHotFoods(hotelId);
    	model.addAttribute("hotFoods", hotFoods);
    	//滞销菜品
    	List<HotFoodItem> poorFoods = hotelService.getPoorFoods(hotelId);
    	model.addAttribute("poorFoods", poorFoods);
        return "hotelInfo";
    }
    
    
    
    @RequestMapping(value = "/similiarIncomes", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelIncome> similiarIncomes(ModelMap model,@RequestParam long hotelId) {
    	//餐厅信息
    	Hotel hotel = hotelService.getById(hotelId);
    	model.addAttribute("hotel",hotel);
    	//相似店铺
    	List<Hotel> similiarHotels = hotelService.getSimiliarHotels(hotelId);
    	model.addAttribute("similiarHotels",similiarHotels);
    	//相似店铺营业额对比
    	List<SimiliarIncomeList> similiarIncomes = hotelService.getSimiliarIncomes(hotel,similiarHotels);
    	List<HotelIncome> hIncomes = new ArrayList<HotelIncome>();
    	
    	for(SimiliarIncomeList lItem:similiarIncomes)
    	{
    		List<Double> incomes = new ArrayList<Double>();
    		HotelIncome hincome = new HotelIncome();
        	for(IncomeItem item:lItem.getIncomes())
        	{
        		incomes.add(item.getIncome());
        	}
        	hincome.setHotelName(lItem.getHotelName());
        	hincome.setIncomes(incomes);
        	hIncomes.add(hincome);
    	}
        return hIncomes;
    }	
    @RequestMapping(value = "/hotelIncome", method = RequestMethod.GET)
    @ResponseBody
    public HotelIncome hotelIncome(ModelMap model,@RequestParam long hotelId) {
    	//餐厅信息
    	Hotel hotel = hotelService.getById(hotelId);
    	model.addAttribute("hotel",hotel);
    	//历史营业额和预测营业额
    	List<IncomeItem> incomeList = hotelService.getIncomeList(hotelId);
    	
    	HotelIncome hincome = new HotelIncome();
    	List<Double> incomes = new ArrayList<Double>();
    	
    	for(IncomeItem item:incomeList)
    	{
    		incomes.add(item.getIncome());
    	}
    	hincome.setHotelName(hotel.getHotelName());
    	hincome.setIncomes(incomes);
        return hincome;
    }	
}
