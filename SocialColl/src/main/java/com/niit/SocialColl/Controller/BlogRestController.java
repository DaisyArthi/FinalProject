package com.niit.SocialColl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialColl.Dao.BlogDAO;
import com.niit.SocialColl.Modal.Blog;

@RestController
public class BlogRestController {

	@Autowired
	BlogDAO blogDAO;
	
	@RequestMapping(value="/getAllBLog",method=RequestMethod.GET)
	public List<Blog> getAllBlog(){
		System.out.println("getAllBlog");
		return blogDAO.getBlogList();
	}
	
	@RequestMapping(value="/BlogEnter",method=RequestMethod.POST)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		 blogDAO.addBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
			}
}
