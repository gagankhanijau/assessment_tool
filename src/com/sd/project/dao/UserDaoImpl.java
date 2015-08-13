package com.sd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.project.bean.Test;
import com.sd.project.bean.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUser(User user) {
		sessionfactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> getUser() {
		@SuppressWarnings("unchecked")
		List<User> userlist = sessionfactory.getCurrentSession()/*.createQuery("from User").list();*/
				.createCriteria(User.class).list();
		return userlist;
	}

	@Override
	public User getUser(String loginId) {
		Criteria cr = sessionfactory.getCurrentSession().createCriteria(Test.class);
		cr.add(Restrictions.eq("email", loginId));
		List<User> userList= cr.list();
		if (userList.size()>0)
			return (User)(userList.get(0));
		else
			return null;

	}

}
