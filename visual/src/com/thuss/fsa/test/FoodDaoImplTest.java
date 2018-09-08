package com.thuss.fsa.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thuss.fsa.dao.FoodDao;
import com.thuss.fsa.model.Food;

public class FoodDaoImplTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring-db.xml");
	
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		FoodDao foodDao = (FoodDao) applicationContext.getBean("foodDao");
		List<Food> list  = foodDao.getAll();
		System.out.println("length:"+list.size());
		fail("Not yet implemented");
		
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
