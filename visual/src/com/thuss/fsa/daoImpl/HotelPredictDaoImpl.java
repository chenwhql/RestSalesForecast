package com.thuss.fsa.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.dao.HotelPredictDao;
import com.thuss.fsa.model.HotelPredict;

@Repository
public class HotelPredictDaoImpl extends BaseDaoImpl implements HotelPredictDao {

	@Override
	public void add(HotelPredict u) {
		this.getSession().save(u);
	}

	@Override
	public void update(HotelPredict u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(HotelPredict u) {
		this.getSession().delete(u);
	}

	@Override
	public HotelPredict getById(long id) {
		return (HotelPredict) this.getSession().get(HotelPredict.class, id);
	}
	
	@Override
	public List<HotelPredict> getAll() {
		String hql = "from HotelPredict";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<HotelPredict>();
	}
}
