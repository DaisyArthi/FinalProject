package com.niit.SocialColl.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SocialColl.Modal.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addBlog(Blog blog) {
		
		try
		{
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(blog);
			trans.commit();
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		
	}

	public List<Blog> getBlogList() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Blog> blogList=session.createQuery("from Blog").list();
		trans.commit();
		session.close();
		return blogList;
	}

	public void deleteBlog(Blog blog) {
		

		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();  
		session.delete(blog);
		trans.commit();
		session.close();
		
	}

	public Blog getBlog(int BlogID) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Blog blog=(Blog)session.get(Blog.class,BlogID);
		trans.commit();
		session.flush();
		session.close();
		return blog;
	}

	public void updateBlog(Blog blog) {
		

		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction(); 
		session.update(blog);
		trans.commit();
		session.flush();
		session.close();
		
	}

	public boolean approveBlog(Blog blog) {
		
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured:"+e);
			return false;
		}
	}

}
