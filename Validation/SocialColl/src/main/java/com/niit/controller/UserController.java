package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {

	@Autowired
    UserDAO userDAO;
	
	//http://localhost:8084/SocialColl/getAllUsers
	@GetMapping("/getAllUsers")
	public List<User> getAllUser(){
    	return userDAO.getList();

	}
	
	//http://localhost:8084/SocialColl/register
	@PostMapping("register")
	public ResponseEntity<User> createUser(@RequestBody User user){
		 userDAO.addUser(user);
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//http://localhost:8084/SocialColl/login
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
    	User validuser=userDAO.login(user);
    	validuser.setOnline(true);
    	userDAO.updateUser(validuser);
    	session.setAttribute("username", validuser.getUsername());
    	return new ResponseEntity<User>(validuser,HttpStatus.OK);
    }
	
	//http://localhost:8084/SocialColl/logout
	@RequestMapping(value="/logout",method=RequestMethod.GET)
    public ResponseEntity<?> logout(HttpSession session){
    	
    	String username=(String)session.getAttribute("username");
    	User user=userDAO.getUserByUsername(username);
    	user.setOnline(false);
    	userDAO.updateUser(user);
    	session.removeAttribute("username");
    	session.invalidate();
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		userDAO.updateUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}
