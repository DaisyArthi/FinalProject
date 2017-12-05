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

	@Override
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
		catch(Exception ex)
		{
			System.out.println("Exception"+ex);
		}
		
	}

	@Override
	public List<Blog> getListBlog() {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Blog> blogList=session.createQuery("from Blog").list();
		trans.commit();
		session.close();
		return blogList;
		
	}

	@Override
	public void updateBlog(Blog blog) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		session.update(blog);
		trans.commit();
		session.flush();
		session.close();
	}

	@Override
	public Blog getBlog(int BlogId) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Blog blog=(Blog)session.get(Blog.class, BlogId);
		trans.commit();
		session.flush();
		session.close();
		return blog;
		
	}

	@Override
	public void approveBlog(Blog blog) {
		
		
	}

	@Override
	public void deleteBlog(int BlogId) {
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Blog blog=(Blog)session.get(Blog.class,BlogId);
		session.delete(blog);
		trans.commit();
		session.clear();
		
	}

}
