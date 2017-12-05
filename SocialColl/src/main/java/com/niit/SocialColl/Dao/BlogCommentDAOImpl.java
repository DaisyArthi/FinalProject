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

	@Override
	public void addBlogc(BlogComment blogcomment) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(blogcomment);
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
	public List<BlogComment> getList() {
		
		return null;
	}

	@Override
	public void updateBlogc(BlogComment blogcomment) {
		
		
	}

	@Override
	public BlogComment getBlogc(int BlogCommentId) {
		
		return null;
	}

	@Override
	public void deleteBlogc(int BlogCommentId) {
		
		
	}

	
	
}
