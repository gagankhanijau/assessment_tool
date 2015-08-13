package com.sd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.sd.project.bean.Test;
import com.sd.project.bean.TestUserMapping;
import com.sd.project.bean.User;

public class TestUserDaoImpl implements TestUserDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveTestUser(TestUserMapping testUser) {
		sessionfactory.getCurrentSession().saveOrUpdate(testUser);
	}

	@Override
	public TestUserMapping getTestUser(int tid, int uid) {
		Criteria cr = sessionfactory.getCurrentSession().createCriteria(Test.class);
		cr.add(Restrictions.eq("tid",tid)).add(Restrictions.eq("uid", uid));
		List<TestUserMapping> testUserList= cr.list();
		if (testUserList.size()>0)
			return (TestUserMapping)(testUserList.get(0));
		else
			return null;
	}

}
