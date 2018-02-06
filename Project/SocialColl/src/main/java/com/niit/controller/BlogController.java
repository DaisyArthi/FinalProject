package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.error;

@RestController
public class BlogController {

	@Autowired
	BlogDAO blogDAO;
	
	//http://localhost:8084/SocialColl/getallblogs
	@GetMapping("/getallblogs")
	public List<Blog> getallblogs()
	{
		return blogDAO.getlist();
	}
	//http://localhost:8084/SocialColl/addblog
	@PostMapping("/addblog")
	public ResponseEntity<?> addblog(@RequestBody Blog blog,HttpSession session)
	{
		blog.setApproved(false);
		if(session.getAttribute("username")==null)
		{
			error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		blogDAO.addblog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	//http://localhost:8084/SocialColl/getblog/id
	@GetMapping("/getblog/{id}")
	public ResponseEntity<?> getblog(@PathVariable int id,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Blog blog = blogDAO.getblog(id);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	//http://localhost:8084/SocialColl/updateblog
	@PostMapping("/updateblog")
	public ResponseEntity<?> updateblog(@RequestBody Blog blog,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		try
		{
		blogDAO.updateblog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		catch(Exception e)
		{
			error err=new error(6,"Unable to update"+e.getMessage());
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
	}
	
	//http://localhost:8084/SocialColl/deleteblog
	@PostMapping("/deleteblog")
	public ResponseEntity<?> deleteblog(@RequestBody Blog blog,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Blog tempblog = blogDAO.getblog(blog.getId());
		blogDAO.deleteblog(tempblog);
		return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);
	}
	
	//http://localhost:8084/SocialColl/approveblog/{id}
	@GetMapping("/approveblog/{id}")
	public ResponseEntity<?> approveblog(@PathVariable("id") int id,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Blog tempblog = blogDAO.getblog(id);
		blogDAO.approveBlog(tempblog);
		return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);
	}
	
	
	//http://localhost:8084/SocialColl/rejectblog/{id}
	@GetMapping("/rejectblog/{id}")
	public ResponseEntity<?> rejectblog(@PathVariable("id") int id,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Blog tempblog = blogDAO.getblog(id);
		blogDAO.rejectBlog(tempblog);
		return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);
	}
	
	@GetMapping("/inclikes/{id}")
	public ResponseEntity<?> inclikes(@PathVariable("id")int id,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
		    error err =new error(5,"UnAuthorized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Blog tempblog = blogDAO.getblog(id);
		blogDAO.incLike(tempblog);
		return new ResponseEntity<Blog>(tempblog,HttpStatus.OK);
	}
}
