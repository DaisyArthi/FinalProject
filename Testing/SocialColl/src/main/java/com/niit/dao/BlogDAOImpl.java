package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addblog(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.save(blog);
		return true;
	}

	
	public List<Blog> getlist() {
	
		return sessionFactory.getCurrentSession().createQuery("from Blogs").list();
	}

	
	public boolean updateblog(Blog blog) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		return true;
	}

	
	public boolean deleteblog(Blog blog) {
		
		Session session =sessionFactory.getCurrentSession();
		session.delete(blog);
		return true;
	}


	public Blog getblog(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Blog blog =(Blog)session.get(Blog.class,id);
		return blog;
	}


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


	
	/*public List<Blog> getapprovelist(int approved) {
		
		return null;
	}*/
	
	
}
