package com.sd.project.dao;

import java.util.List;

import com.sd.project.bean.User;

public interface UserDao {
	public void saveUser(User user);

	public List<User> getUser();
	
	public User getUser(String loginId);
}
