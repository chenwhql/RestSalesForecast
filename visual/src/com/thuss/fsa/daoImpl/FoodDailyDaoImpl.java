package com.thuss.fsa.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.dao.FoodDailyDao;
import com.thuss.fsa.model.FoodDaily;

@Repository
public class FoodDailyDaoImpl extends BaseDaoImpl implements FoodDailyDao {

	@Override
	public void add(FoodDaily u) {
		this.getSession().save(u);
	}

	@Override
	public void update(FoodDaily u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(FoodDaily u) {
		this.getSession().delete(u);
	}

	@Override
	public FoodDaily getById(long id) {
		return (FoodDaily) this.getSession().get(FoodDaily.class, id);
	}
	
	@Override
	public List<FoodDaily> getAll() {
		String hql = "from FoodDaily";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<FoodDaily>();
	}
}
