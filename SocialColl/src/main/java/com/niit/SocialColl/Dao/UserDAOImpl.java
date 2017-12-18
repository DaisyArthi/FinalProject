package com.niit.SocialColl.Dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialColl.Modal.User;

@Repository
public class UserDAOImpl implements UserDAO {

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
	public User getUser(String userName) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		User user=(User)session.get(User.class,userName);
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

}
