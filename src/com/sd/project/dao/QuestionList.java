package com.sd.project.dao;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.sd.project.bean.Questions;

public class QuestionList {

	public static List<Questions> getQuestionList(SessionFactory factory) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		List<Questions> questions = null;
		try {
			tx = session.beginTransaction();
			questions = session.createQuery("FROM Questions").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return questions;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory;
		AnnotationConfiguration cf = new AnnotationConfiguration();
		cf.configure("hibernate.cfg.xml"); // to be changed
		factory = cf.buildSessionFactory();
		Session session = factory.openSession();
		// Transaction tx = null;
		session.beginTransaction();

		Questions q1 = new Questions();
		q1.setTestId(1);
		q1.setQuestionId(1);
		q1.setQuestion("This is Question");
		q1.setOption4("option4");
		q1.setOption3("option3");
		q1.setOption2("option2");
		q1.setOption1("option1");
		q1.setAnswer("answer");
		Questions q2 = new Questions();
		q2.setTestId(1);
		q2.setQuestionId(2);
		q2.setQuestion("This is Question");
		q2.setOption4("option4");
		q2.setOption3("option3");
		q2.setOption2("option2");
		q2.setOption1("option1");
		q2.setAnswer("answer");
		session.save(q1);

		session.save(q2);

		session.getTransaction().commit();
		session.close();
		factory.close();

		List ques = getQuestionList(factory);

		System.out.println(ques.size());

	}

}
