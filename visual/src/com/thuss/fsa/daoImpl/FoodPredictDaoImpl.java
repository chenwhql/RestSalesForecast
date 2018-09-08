package com.thuss.fsa.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.model.FoodPredict;

@Repository
public class FoodPredictDaoImpl extends BaseDaoImpl implements FoodPredictDao {

	@Override
	public void add(FoodPredict u) {
		this.getSession().save(u);
	}

	@Override
	public void update(FoodPredict u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(FoodPredict u) {
		this.getSession().delete(u);
	}

	@Override
	public FoodPredict getById(long id) {
		return (FoodPredict) this.getSession().get(FoodPredict.class, id);
	}
	
	@Override
	public List<FoodPredict> getAll() {
		String hql = "from FoodPredict";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<FoodPredict>();
	}
}
