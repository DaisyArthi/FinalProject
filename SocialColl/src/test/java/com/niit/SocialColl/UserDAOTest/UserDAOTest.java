package com.niit.SocialColl.UserDAOTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialColl.Dao.UserDAO;
import com.niit.SocialColl.Modal.User;

public class UserDAOTest {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.SocialCollBackEnd");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		
	  User user= new User();
	  user.setUserName("Annie");
	  user.setName("Anne Divya");
	  user.setPassword("Anne");
	  user.setEmail("anniedivya1808@gmail.com");
	  user.setContact("chennai");
	  user.setDOB("18/08/2000");
	  user.setRole("Student");
	  user.setStatus("S");
	 
	  //assertTrue("Problem in Inserting User",userDAO.addUser(user));
	}
	
	@Test
	public void getUserTest()
	{
		User user = userDAO.getUser("Annie");
		assertNotNull("User not Found",user);
		
		System.out.println("User Name: "+user.getName());
		System.out.println("Email : "+user.getEmail());
		
	}
	
	@Test
	public void deleteUserTest()
	{
		User user =(User)userDAO.getUser("Annie");
		//assertTrue("Problem in Deleting",userDAO.deleteUser(user));
	}
	@Test
	public void updateUserTest()
	{
		User user = new User();
		user.setUserName("Annie");
	}
}
