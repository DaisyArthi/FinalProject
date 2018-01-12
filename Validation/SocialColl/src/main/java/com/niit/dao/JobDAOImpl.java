package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Job;

@Repository
@Transactional
public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;

	
	public void addjob(Job job) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(job);
		
	}

	
	public List<Job> getAllJobs() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Job");
		return query.list();
	}

	
	public Job getJob(int jobId) {
		
		Session session = sessionFactory.getCurrentSession();
		Job job = (Job)session.get(Job.class,jobId);
		return job;
	}
	
	
}
