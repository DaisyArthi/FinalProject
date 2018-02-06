package com.niit.blogtest;





import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

public class BlogDAOTest {
	
	static BlogDAO blogDAO;
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext annotationConfigcontext = new AnnotationConfigApplicationContext();
		annotationConfigcontext.scan("com.niit");
		annotationConfigcontext.refresh();
		
		blogDAO=(BlogDAO)annotationConfigcontext.getBean("blogDAO");
	}
	
	@Test
	public void addBlogTest()
	{
		Blog blog = new Blog();
		blog.setId(42);
		blog.setBlogName("Java EE");
		blog.setDescription("It is an enterprise edition in java.is a set of specifications, extending java SE with specifications for enterprise features such as distributed computing and web services.");
		blog.setLikes(3);
		blog.setApproved(true);
		
		assertTrue("problem in inserting blog",blogDAO.addblog(blog));
		
	}
	
	

	

}
