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

	
	public void addblog(Blog blog) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(blog);
		
	}

	
	public List<Blog> getlist() {
		
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog");
		return query.list();
	}

	
	public void updateblog(Blog blog) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		
	}

	
	public void deleteblog(Blog blog) {
		
		Session session =sessionFactory.getCurrentSession();
		session.delete(blog);
		
	}


	public Blog getblog(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Blog blog =(Blog)session.get(Blog.class,id);
		return blog;
	}


	public void approveBlog(Blog blog) {
		
		try
		{
		blog.setApproved(true);	
		sessionFactory.getCurrentSession().update(blog);
		}
		catch(Exception e)
		{
		 System.out.println("Error" +e);
		}
		
	}


	public void rejectBlog(Blog blog) {
		
		try
		{
		blog.setApproved(false);	
		sessionFactory.getCurrentSession().update(blog);
		}
		catch(Exception e)
		{
		 System.out.println("Error" +e);
		}
	}


	
	public void incLike(Blog blog) {
		
		try
		{
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
		}
		catch(Exception e)
		{
			System.out.println("Error" +e);
		}
		
	}


	
	/*public List<Blog> getapprovelist(int approved) {
		
		return null;
	}*/
	
	
}
