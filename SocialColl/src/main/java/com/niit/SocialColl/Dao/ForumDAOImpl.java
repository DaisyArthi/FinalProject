package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.SocialColl.Modal.Forum;

@Repository
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addForum(Forum forum) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(forum);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

	public List<Forum> getForumList() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Forum> forumList=session.createQuery("from Forum").list();
		trans.commit();
		session.close();
		return forumList;
	}

	public void deleteForum(Forum forum) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		session.delete(forum);
		trans.commit();
		session.close();

		
	}

}
