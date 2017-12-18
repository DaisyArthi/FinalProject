package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialColl.Modal.ForumComment;

@Repository
public class ForumCommentDAOImpl implements ForumCommentDAO{

	@Autowired
	SessionFactory sessionFactory;

	public void addForumComment(ForumComment forumcomment) {
		try
		{
			Session session =sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(forumcomment);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

	public List<ForumComment> getForumCommentList() {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ForumComment> forumcommentList=session.createQuery("from ForumComment").list();
		trans.commit();
		session.close();
		return forumcommentList;
		
	}
	
	
}
