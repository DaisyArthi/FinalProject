package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialColl.Modal.BlogComment;

@Repository
public class BlogCommentDAOImpl implements BlogCommentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBlogComment(BlogComment blogcomment) {
		
		try
		{
			Session session =sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(blogcomment);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}
   
	public List<BlogComment> getBlogCommentList() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<BlogComment> blogcommentList=session.createQuery("from BlogComment").list();
		trans.commit();
		session.close();
		return blogcommentList;
	}

}
