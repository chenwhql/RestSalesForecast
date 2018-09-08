package com.thuss.fsa.daoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.dao.FoodDao;
import com.thuss.fsa.item.FoodItem;
import com.thuss.fsa.item.HotFoodItem;
import com.thuss.fsa.item.SaleItem;
import com.thuss.fsa.model.Food;

@Repository
public class FoodDaoImpl extends BaseDaoImpl implements FoodDao {

	@Override
	public void add(Food u) {
		this.getSession().save(u);
	}

	@Override
	public void update(Food u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(Food u) {
		this.getSession().delete(u);
	}

	@Override
	public Food getById(long id) {
		return (Food) this.getSession().get(Food.class, id);
	}
	
	@Override
	public List<Food> getAll() {
		String hql = "from Food";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<Food>();
	}

	@Override
	public int searchRowCount(String keyword) {
		String sql = "select f.*,h.hotel_name,s.total_num from "
				+ "(select food_id,SUM(total_num) as total_num from food_daily "
				+ "where food_name like '%'+?+'%' and "
				+ "check_date BETWEEN '2016-06-24' AND '2016-06-30' "
				+ "GROUP BY food_id) as s,food f,Hotel h where s.food_id = f.food_id "
				+ "and f.hotel_id= h.hotel_id ORDER BY s.total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, keyword);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list.size();
		else
			return 0;
	}
	
	@Override
	public List<FoodItem> searchForPage(String keyword, int offset, int length) {
		String sql = "select f.*,h.hotel_name,s.total_num from "
				+ "(select food_id,SUM(total_num) as total_num from food_daily "
				+ "where food_name like '%'+?+'%' and "
				+ "check_date BETWEEN '2016-06-24' AND '2016-06-30' "
				+ "GROUP BY food_id) as s,food f,Hotel h where s.food_id = f.food_id "
				+ "and f.hotel_id= h.hotel_id ORDER BY s.total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, keyword);
        query.setFirstResult(offset);
        query.setMaxResults(length);
		List list = query.list();
		List<FoodItem> foodItems  =  new ArrayList<FoodItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				FoodItem item = new FoodItem();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setHotelId(((BigInteger)values[1]).longValue());
				item.setFoodName((String)values[2]);
				item.setUnitMoney((Integer)values[3]);
				item.setCateCode(((BigInteger)values[4]).longValue());
				item.setCateName((String)values[5]);
				item.setHotelName((String)values[6]);
				item.setTotalNum((Integer)values[7]);
				foodItems.add(item);
			}
		}
		return foodItems;
	}
	

	@Override
	public List<HotFoodItem> getHotFoods() {
		String sql = "select top 10 s.food_id,s.total_num,f.food_name from "
				+" (select food_id,SUM(total_num) as total_num from food_daily where check_date "
				+" BETWEEN '2016-06-24' and '2016-06-30' GROUP by food_id) as s,food f "
				+" where s.food_id = f.food_id  and food_name not like '%串%' and food_name not like '%烤%' order by total_num desc";
		Query query = this.getSession().createSQLQuery(sql);
		List list = query.list();
		List<HotFoodItem> itemList = new ArrayList<HotFoodItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				HotFoodItem item = new HotFoodItem();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setTotalNum((Integer)values[1]);
				item.setFoodName((String)values[2]);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<HotFoodItem> getHotFoods(long hotelId) {
		String sql = "select top 10 s.food_id,f.food_name,s.total_num from "
				+ " (select food_id,sum(total_num) as total_num from food_daily "
				+ " where hotel_id = ? GROUP BY food_id ) as s,food f "
				+ " where s.food_id=f.food_id  ORDER BY total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,hotelId);
		List list = query.list();
		List<HotFoodItem> itemList = new ArrayList<HotFoodItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				HotFoodItem item = new HotFoodItem();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setFoodName((String)values[1]);
				item.setTotalNum((Integer)values[2]);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<HotFoodItem> getPoorFoods(long hotelId) {
		String sql = "SELECT top 10 food_id,food_name from food where hotel_id=? and food_id "
				+ "not IN(select food_id from food_daily where hotel_id=?)";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,hotelId);
		query.setParameter(1,hotelId);
		List list = query.list();
		List<HotFoodItem> itemList = new ArrayList<HotFoodItem>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				HotFoodItem item = new HotFoodItem();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setFoodName((String)values[1]);
				item.setTotalNum(0);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<SaleItem> getSalesList(long foodId) {
		
		
		List<SaleItem> itemList = new ArrayList<SaleItem>();
		
		String sql = "select check_date,total_num from food_daily "
				+ "WHERE food_id=? and check_date between '2016-06-17' and '2016-06-30' ORDER BY check_date";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,foodId);
		List list = query.list();

		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				SaleItem item = new SaleItem();
				Object [] values = (Object [])list.get(i);
				item.setDate((String)values[0]);
				item.setSoldNum((Integer)values[1]);
				itemList.add(item);
			}
		}
//		sql = "select check_date,total_num from food_predict "
//				+ "WHERE food_id=? and check_date between '2016-07-01' and '2016-07-07' ORDER BY check_date";
//		query = this.getSession().createSQLQuery(sql);
//		query.setParameter(0,foodId);
//		list = query.list();
//		if (list != null && list.size() > 0)
//		{
//			for(int i = 0; i < list.size();i++)
//			{
//				SaleItem item = new SaleItem();
//				Object [] values = (Object [])list.get(i);
//				item.setDate((String)values[0]);
//				item.setSoldNum((Integer)values[1]);
//				itemList.add(item);
//			}
//		}
		
		return itemList;
	}
	
	@Override
	public List<SaleItem> getSSalesList(long foodId) {
		
		
		List<SaleItem> itemList = new ArrayList<SaleItem>();
		
		String sql = "select check_date,total_num from food_daily "
				+ "WHERE food_id=? and check_date between '2016-06-10' and '2016-06-23' ORDER BY check_date";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,foodId);
		List list = query.list();

		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				SaleItem item = new SaleItem();
				Object [] values = (Object [])list.get(i);
				item.setDate((String)values[0]);
				item.setSoldNum((Integer)values[1]);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<Food> getSimiliarFoods(Food f) {
		
		String sql = "select top 3 s.food_id,f.food_name,f.hotel_id "
				+ "from (select food_id,sum(total_num) as total_num "
				+ "from food_daily where food_id <> ? and food_name like '%'+?+'%' "
				+ "GROUP BY food_id) as s,food f where s.food_id = f.food_id ORDER BY total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,f.getFoodId());
		query.setParameter(1, f.getFoodName());
		List list = query.list();
		List<Food> itemList = new ArrayList<Food>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				Food item = new Food();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setFoodName((String)values[1]);
				item.setHotelId(((BigInteger)values[2]).longValue());
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<Food> getTop10(Food food) {
		String sql = "select top 10 s.food_id,f.unit_money from (select food_id,sum(total_num) as total_num "
				+ "from food_daily where food_name like '%'+?+'%' "
				+ "GROUP BY food_id) as s,food f where s.food_id = f.food_id ORDER BY total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		query.setParameter(0,food.getFoodName());
		List list = query.list();
		List<Food> itemList = new ArrayList<Food>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				Food item = new Food();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setUnitMoney((Integer)values[1]);
				itemList.add(item);
			}
		}
		return itemList;
	}

	@Override
	public List<Food> getGroupFoods(Food food) {
		String sql = "SELECT top 5 f.* from (SELECT food_name,sum(num) as total_num "
				+ "from orders where hotel_id = ? and food_name<>? and "
				+ "totalOrder_id in (select totalOrder_id from orders "
				+ "where food_name = ?  and hotel_id=?) "
				+ "GROUP BY food_name) as s,food f where s.food_name = f.food_name "
				+ "and  f.hotel_id=? ORDER BY total_num DESC";
		Query query = this.getSession().createSQLQuery(sql);
		
		query.setParameter(0,food.getHotelId());
		query.setParameter(1,food.getFoodName());
		query.setParameter(2,food.getFoodName());
		query.setParameter(3,food.getHotelId());
		query.setParameter(4,food.getHotelId());
		
		List list = query.list();
		List<Food> itemList = new ArrayList<Food>();
		if (list != null && list.size() > 0)
		{
			for(int i = 0; i < list.size();i++)
			{
				Food item = new Food();
				Object [] values = (Object [])list.get(i);
				item.setFoodId(((BigInteger)values[0]).longValue());
				item.setHotelId(((BigInteger)values[1]).longValue());
				item.setFoodName((String)values[2]);
				item.setUnitMoney((Integer)values[3]);
				item.setCateName((String)values[5]);
				itemList.add(item);
			}
		}
		return itemList;
	}


}
