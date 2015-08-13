package com.sd.project.dao;

import com.sd.project.bean.Test;

public interface TestDao {
	public void saveTest(Test test);
	public Test getTest(int id);
}
