package com.thuss.fsa.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.thuss.fsa.dao.HotelDailyDao;
import com.thuss.fsa.model.HotelDaily;

@Repository
public class HotelDailyDaoImpl extends BaseDaoImpl implements HotelDailyDao {

	@Override
	public void add(HotelDaily u) {
		this.getSession().save(u);
	}

	@Override
	public void update(HotelDaily u) {
			this.getSession().update(u);
	}
	
	@Override
	public void delete(HotelDaily u) {
		this.getSession().delete(u);
	}

	@Override
	public HotelDaily getById(long id) {
		return (HotelDaily) this.getSession().get(HotelDaily.class, id);
	}
	
	@Override
	public List<HotelDaily> getAll() {
		String hql = "from HotelDaily";
		Query query = this.getSession().createQuery(hql);
		List list = query.list();
		if (list != null && list.size() > 0)
			return list;
		else
			return new ArrayList<HotelDaily>();
	}
}
