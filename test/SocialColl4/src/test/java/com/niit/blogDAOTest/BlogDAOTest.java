package com.niit.blogDAOTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class BlogDAOTest {

	@Autowired
	static BlogDAO blogDAO;
	
		
	
	@BeforeClass
	@Autowired
	public static void initialize()
	{
		
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog = new Blog();
		blog.setId(5);
		blog.setBlogName("JSP");
		blog.setDescription("JavaServer Pages is a technology that helps software developers create dynamically generated web pages based on HTML, XML, or other document types.");
		blog.setLikes(3);
		blog.setApproved(true);
		
		assertTrue("problem in inserting blog",blogDAO.addblog(blog));
	
		
	}
	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getblog(1);
		blog.setDescription("Java EE is a java enterprise edition");
		blog.setBlogName("Java EE");
		assertTrue("blog updated",blogDAO.updateblog(blog));
	}
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getblog(1);
		assertTrue("blog updated",blogDAO.deleteblog(blog));
	}
	
	@Ignore
	@Test
	public void getblogTest()
	{
		Blog blog=blogDAO.getblog(2);
		System.out.println("blog name "+blog.getBlogName());
		System.out.println("blog content"+blog.getDescription());
	}
	
	@Test
	public void getAllBlogTest()
	{
		List<Blog>blogList=(List<Blog>)blogDAO.getlist();
		for(Blog blog:blogList)
		{
			System.out.println("blog is"+blog.getId()+":::"+"blog name::"+blog.getBlogName()+"");
		}
	}
}
