package com.sd.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.project.bean.Questions;
					

@Repository("QuestionDao")
public class QuestionDaoImp implements QuestionDao {
	
	@Autowired
	private SessionFactory sessionfactory;	
	public void saveQuestion(Questions question) {
		sessionfactory.getCurrentSession().saveOrUpdate(question);
	}

	@Override
	public List<Questions> getQuestions() {
		@SuppressWarnings("unchecked")
		List<Questions> questionlist = sessionfactory.getCurrentSession()
				.createCriteria(Questions.class).list();
		return questionlist;
	}

	@Override
	public List<Questions> getQuestions(int tid) {
		
		Criteria cr=sessionfactory.getCurrentSession().createCriteria(Questions.class);
		cr.add(Restrictions.eq("tid",tid));
		List <Questions> results = cr.list();
		
		if(results.size()>0)
			return(results);
		
		else
			return null;
	}

}
