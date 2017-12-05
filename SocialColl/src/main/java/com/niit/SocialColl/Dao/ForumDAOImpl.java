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
	
	@Override
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
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
		}
		
	}

	@Override
	public List<Forum> getList() {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Forum> forumList=session.createQuery("from Forum").list();
		trans.commit();
		session.close();
		return forumList;
		
	}

	@Override
	public void updateForum(Forum forum) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(forum);
		trans.commit();
		session.flush();
		session.close();
		
	}

	@Override
	public Forum getForum(int ForumId) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Forum forum=(Forum)session.get(Forum.class, ForumId);
		trans.commit();
		session.flush();
		session.close();
		return forum;
		
	}

	@Override
	public void approveForum(Forum forum) {
		
		
	}

	@Override
	public void deleteForum(int ForumId) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Forum forum=(Forum)session.get(Forum.class, ForumId);
		session.delete(forum);
		trans.commit();
		session.clear();
	}

}
