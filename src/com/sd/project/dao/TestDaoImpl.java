package com.sd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.sd.project.bean.Test;

public class TestDaoImpl implements TestDao {

	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public void saveTest(Test test) {
		sessionfactory.getCurrentSession().saveOrUpdate(test);
	}

	@Override
	public Test getTest(int id) {
		Criteria cr = sessionfactory.getCurrentSession().createCriteria(Test.class);
		cr.add(Restrictions.eq("tid", id));
		List<Test> testList= cr.list();
		if (testList.size()>0)
			return (Test)testList.get(0);
		else
			return null;
	}

}
