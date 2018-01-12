package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

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
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

	
	public List<User> getList() {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> userList=session.createQuery("from User").list();
		trans.commit();
		session.close();
		return userList;
	}

	
	public void deleteUser(User user) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		session.delete(user);
		trans.commit();
		session.close();
	}

	
	public User getUser(String username) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		User user=(User)session.get(User.class,username);
		trans.commit();
		session.flush();
		session.close();
		return user;
	
	}

	
	public void updateUser(User user) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction(); 
		session.update(user);
		trans.commit();
		session.flush();
		session.close();
	}

	public User login(User user) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from User where username=? and password=?");
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		trans.commit();
		return (User)query.uniqueResult();
		
	}
	
	public User getUserByUsername(String username)
	{
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		User user=(User)session.get(User.class,username);
		trans.commit();
		return user;
	}

}
