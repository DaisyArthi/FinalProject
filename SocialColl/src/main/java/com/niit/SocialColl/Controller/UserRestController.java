package com.niit.SocialColl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialColl.Dao.UserDAO;
import com.niit.SocialColl.Modal.User;

@RestController
public class UserRestController {

	@Autowired
    UserDAO userdao;
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	public List<User> getAllUser(){
		System.out.println("getAllUsers");
		return userdao.getList();
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		 userdao.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
			}
}
