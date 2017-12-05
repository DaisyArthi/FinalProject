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
	
	@Override
	public void addForumc(ForumComment forumcomment) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(forumcomment);
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
	public List<ForumComment> getList() {
		
		return null;
	}

	@Override
	public void updateForumc(ForumComment forumcomment) {
	
		
	}

	@Override
	public ForumComment getForumc(int ForumCommentId) {
		
		return null;
	}

	@Override
	public void deleteForumc(int ForumCommentId) {
		
		
	}

}
