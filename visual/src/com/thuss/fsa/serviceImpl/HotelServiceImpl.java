package com.thuss.fsa.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuss.fsa.dao.FoodDao;
import com.thuss.fsa.dao.HotelDao;
import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.HotHotelItem;
import com.thuss.fsa.item.HotelItem;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.item.SimiliarIncomeList;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.service.HotelService;
import com.thuss.fsa.util.Page;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private	HotelDao hotelDao;
	@Autowired
	private	FoodDao foodDao;
	@Override
	public void add(Hotel u) {
		hotelDao.add(u);
	}
	@Override
	public void update(Hotel u) {
		hotelDao.update(u);
	}

	@Override
	public void delete(Hotel u) {
		hotelDao.delete(u);
	}
	
	@Override
	public List<Hotel> getAll() {
		return hotelDao.getAll();
	}
	@Override
	public Hotel getById(long id) {
		return hotelDao.getById(id);
	}
	
	
	@Override
	public List<HotHotelItem> getHotHotels() {
		List<HotHotelItem> hotelList = hotelDao.getHotHotels();
		return hotelList;
	}
	@Override
	public List<IncomeItem> getIncomeList(long hotelId) {
		return hotelDao.getIncomeList(hotelId);
	}
	
	@Override
	public List<IncomeItem> getHistoryIncome(long hotelId) {
		return hotelDao.getHistoryIncome(hotelId);
	}
	
	@Override
	public List<Hotel> getSimiliarHotels(long hotelId) {
		
		return hotelDao.getSimiliarHotels(hotelId);
	}
	@Override
	public List<SimiliarIncomeList> getSimiliarIncomes(Hotel hotel,List<Hotel> similiarHotels) {
		
		List<SimiliarIncomeList> silists  = new ArrayList<SimiliarIncomeList>();
		SimiliarIncomeList silist = new SimiliarIncomeList();
		silist.setHotelName(hotel.getHotelName());
		silist.setIncomes(getHistoryIncome(hotel.getHotelId()));
		silists.add(silist);
		for(Hotel h:similiarHotels)
		{
			silist = new SimiliarIncomeList();
			silist.setHotelName(h.getHotelName());
			silist.setIncomes(getHistoryIncome(h.getHotelId()));
			silists.add(silist);
		}
		return silists;
	}
	@Override
	public List<HotFoodItem> getHotFoods(long hotelId) {
		return foodDao.getHotFoods(hotelId);
	}
	@Override
	public List<HotFoodItem> getPoorFoods(long hotelId) {
		return foodDao.getPoorFoods(hotelId);
	}
	@Override
	public List<Hotel> searchHotel(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page searchForPage(String keyword, int currentPage, int pageSize) {
		
		Page page  = new Page();
		
		int allRow = hotelDao.searchRowCount(keyword);
		
		int offset = page.countOffset(currentPage,pageSize);
		
		List<HotelItem> list = hotelDao.searchForPage(keyword, offset, pageSize);
		
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setKeyword(keyword);
		page.setList(list);
		
		return page;	
	}


}
