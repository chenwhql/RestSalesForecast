package com.thuss.fsa.daoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.dao.HotelDao;
import com.thuss.fsa.item.FoodItem;
import com.thuss.fsa.item.HotHotelItem;
import com.thuss.fsa.item.HotelItem;
import com.thuss.fsa.item.IncomeItem;
import com.thuss.fsa.model.Food;
import com.thuss.fsa.model.Hotel;
import com.thuss.fsa.util.DoubleUtil;

@Repository
public class HotelDaoImpl extends BaseDaoImpl implements HotelDao {

	@Override
	public void add(Hotel u) {
		this.getSession().save(u);
	}

	@Override
	public void update(Hotel u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(Hotel u) {
		this.getSession().delete(u);
	}

	@Override
	public Hotel getById(long id) {
		return (Hotel) this.getSession().get(Hotel.class, id);
	}
	
	@Override
	public List<Hotel> getAll() {
		String hql = "from Hotel";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<Hotel>();
	}

	@Override
	public List<HotHotelItem> getHotHotels() {
		String sql = "select top 10 s.hotel_id,h.hotel_name,s.total_income from "
					+"(select hotel_id,sum(total_need_money) as total_income" 
					+" from hotel_daily where the_date BETWEEN '2016-06-24' and '2016-06-30' GROUP by hotel_id) as s,hotel h"
					+" where s.hotel_id =  h.hotel_id order by s.total_income desc";
		Query query = this.getSession().createSQLQuery(sql);
		List list = query.list();
		List<HotHotelItem> itemList = new ArrayList<HotHotelItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				HotHotelItem item = new HotHotelItem();
				Object [] values = (Object [])list.get(i);
				item.setHotelId(((BigInteger)values[0]).longValue());
				item.setHotelName((String)values[1]);
				double income = DoubleUtil.double1bit((double)values[2]);
				item.setTotalIncome(income);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<IncomeItem> getIncomeList(long hotelId) {
		
		List<IncomeItem> itemList = new ArrayList<IncomeItem>();
		//历史营业额
		String sql ="select the_date,total_need_money from hotel_daily "
				+ "where the_date BETWEEN '2016-06-17' AND '2016-06-30' AND hotel_id=? ORDER BY the_date";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,hotelId);
		List list = query.list();

		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				IncomeItem item = new IncomeItem();
				Object [] values = (Object [])list.get(i);
				item.setDate((String)values[0]);
				item.setIncome((double)values[1]);
				itemList.add(item);
			}
		}
		
//		sql = "select the_date,total_need_money from hotel_predict "
//				+ "where the_date BETWEEN '2016-07-01' AND '2016-07-07' "
//				+ "and hotel_id=? ORDER BY the_date";
//		query = this.getSession().createSQLQuery(sql);
//		query.setParameter(0,hotelId);
//		list = query.list();
//		if (list != null && list.size() > 0)
//		{
//			for(int i = 0; i < list.size();i++)
//			{
//				IncomeItem item = new IncomeItem();
//				Object [] values = (Object [])list.get(i);
//				item.setDate((String)values[0]);
//				double tmp = DoubleUtil.double1bit((double)values[1]);
//				item.setIncome(tmp);
//				itemList.add(item);
//			}
//		}
		
		return itemList;
	}
	@Override
	public List<IncomeItem> getHistoryIncome(long hotelId) {
		
		List<IncomeItem> itemList = new ArrayList<IncomeItem>();
		//历史营业额
		String sql ="select the_date,total_need_money from hotel_daily "
				+ "where the_date BETWEEN '2016-06-10' AND '2016-06-23' AND hotel_id=? ORDER BY the_date";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,hotelId);
		List list = query.list();

		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				IncomeItem item = new IncomeItem();
				Object [] values = (Object [])list.get(i);
				item.setDate((String)values[0]);
				item.setIncome((double)values[1]);
				itemList.add(item);
			}
		}
		return itemList;
	}
	
	@Override
	public List<Hotel> getSimiliarHotels(long hotelId) {
		String sql ="select * from getSimiliarHotels(?)";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,hotelId);
		List list = query.list();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				Hotel item = new Hotel();
				Object [] values = (Object [])list.get(i);
				item.setHotelId(((BigInteger)values[0]).longValue());
				item.setHotelName((String)values[1]);
				hotelList.add(item);
			}
		}
		return hotelList;
	}

	@Override
	public int searchRowCount(String keyword) {
		
		String sql = "SELECT s.hotel_id,h.hotel_name,h.caixi,h.format,h.num_of_food,s.total_orders,s.total_need_money "
				+ "from (select d.hotel_id,SUM(total_orders) as total_orders,SUM(total_need_money) as total_need_money "
				+ "from hotel_daily d,hotel h where d.hotel_id= h.hotel_id and hotel_name like '%'+?+'%' and the_date "
				+ "BETWEEN '2016-06-24' AND '2016-06-30' GROUP BY d.hotel_id) as s,hotel h "
				+ "WHERE s.hotel_id=h.hotel_id ORDER BY s.total_need_money desc";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, keyword);
		List list = query.list();

		if (list != null && list.size() > 0)
		{
			return list.size();
		}
		else
			return 0;
	}

	@Override
	public List<HotelItem> searchForPage(String keyword, int offset, int length) {
		
		String sql = "SELECT s.hotel_id,h.hotel_name,h.caixi,h.format,h.num_of_food,s.total_orders,s.total_need_money "
				+ "from (select d.hotel_id,SUM(total_orders) as total_orders,SUM(total_need_money) as total_need_money "
				+ "from hotel_daily d,hotel h where d.hotel_id= h.hotel_id and hotel_name like '%'+?+'%' and the_date "
				+ "BETWEEN '2016-06-24' AND '2016-06-30' GROUP BY d.hotel_id) as s,hotel h "
				+ "WHERE s.hotel_id=h.hotel_id ORDER BY s.total_need_money desc";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, keyword);
        query.setFirstResult(offset);
        query.setMaxResults(length);
		List list = query.list();
		List<HotelItem> hotelItems  =  new ArrayList<HotelItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				HotelItem item = new HotelItem();
				Object [] values = (Object [])list.get(i);
				item.setHotelId(((BigInteger)values[0]).longValue());
				item.setHotelName((String)values[1]);
				item.setCaixi((String)values[2]);
				item.setFormat((String)values[3]);
				item.setNumOfFood((Integer)values[4]);
				item.setTotalOrders((Integer)values[5]);
				double totalMoney = DoubleUtil.double1bit((double)values[6]);
				item.setTotalMoney(totalMoney);
				hotelItems.add(item);
			}
			return hotelItems;
		}
		else
			return null;

	}
}
