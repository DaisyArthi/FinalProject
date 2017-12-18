package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.SocialColl.Modal.Job;

@Repository
public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;

	public void addJob(Job job) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(job);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

	public List<Job> getJobList() {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Job> jobList=session.createQuery("from Job").list();
		trans.commit();
		session.close();
		return jobList;
		
	}

	public void deleteJob(Job job) {
		

		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		session.delete(job);
		trans.commit();
		session.close();
		
	}
	
	
}
