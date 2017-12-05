package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.SocialColl.Modal.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	SessionFactory sessionFactory;

	
	public void addUser(User user) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(user);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
		}
	}


	@Override
	public List<User> getList() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> userList=session.createQuery("from User").list();
		trans.commit();
		session.close();
		return userList;
		
	}


	@Override
	public void updateUser(User user) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(user);
		trans.commit();
		session.flush();
		session.close();
		
	}


	@Override
	public User getUser(String UserName) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		User user=(User)session.get(User.class, UserName);
		trans.commit();
		session.flush();
		session.close();
		return user;
		
	}


	@Override
	public void approveUser(User user) {
		
		
	}


	@Override
	public void deleteUser(String UserName) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		User user=(User)session.get(User.class, UserName);
		session.delete(user);
		trans.commit();
		session.clear();
		
	}
	
	
}
