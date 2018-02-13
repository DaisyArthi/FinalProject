package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{


	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean addblog(Blog blog) {

		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
		return false;
	}

	
	public List<Blog> getlist() {
		
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
		}

	@Transactional
	public boolean updateblog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception ex)
		{
			System.out.println("Error"+ex);
		}
		return false;
	}

	@Transactional
	public boolean deleteblog(Blog blog) {
		
		try
		{
		sessionFactory.getCurrentSession().delete(blog);
		return true;
		}
		catch(Exception ex)
		{
			System.out.println("Error"+ex);
		}
		return false;
	}

	
	public Blog getblog(int id) {
		Session session = sessionFactory.openSession();
		Blog blog = (Blog) session.get(Blog.class, new Integer(id));
		return blog;
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		try
		{
		blog.setApproved(true);	
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
		 System.out.println("Error" +e);
		}
		return false;
	}

	@Transactional
	public boolean rejectBlog(Blog blog) {
		try
		{
		blog.setApproved(false);	
		sessionFactory.getCurrentSession().update(blog);
		return true;
		}
		catch(Exception e)
		{
		 System.out.println("Error" +e);
		}
		return false;
	}

	@Transactional
	public boolean incLike(Blog blog) {
		try
		{
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error" +e);
		}
		return false;
	}
	

}
