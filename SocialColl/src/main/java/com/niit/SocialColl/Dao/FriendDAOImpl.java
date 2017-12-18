package com.niit.SocialColl.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialColl.Modal.Friend;

@Repository
public class FriendDAOImpl implements FriendDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addFriend(Friend friend) {
		
		try
		{
			Session session =sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(friend);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

}
