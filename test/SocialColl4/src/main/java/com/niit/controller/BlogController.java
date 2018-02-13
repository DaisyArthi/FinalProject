package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@RestController
public class BlogController {

	@Autowired
	BlogDAO blogDAO;
	
	@PostMapping("addblog")
	public ResponseEntity<Blog> addblog(@RequestBody Blog blog,HttpSession session)
	{
		blogDAO.addblog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
}
