package com.sd.project.dao;

import com.sd.project.bean.TestUserMapping;

public interface TestUserDao {
	public void saveTestUser(TestUserMapping testUser);
	public TestUserMapping getTestUser(int tid, int uid);
}
