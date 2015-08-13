package com.sd.project.dao;

import java.util.List;

import com.sd.project.bean.Questions;

public interface QuestionDao {
	public void saveQuestion ( Questions question );
	public List<Questions> getQuestions();
	public List<Questions> getQuestions(int tid);
	
}
