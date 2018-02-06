package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Friend;
import com.niit.model.User;
import com.niit.model.error;

@RestController
public class FriendController {

	@Autowired(required=true)
	FriendDAO friendDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/getsuggestedusers")
	public ResponseEntity<?> getListOfSuggestedUsers(HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		List<User> suggestUsers=friendDAO.getListOfSuggestedUsers(username);
		return new ResponseEntity<List<User>>(suggestUsers,HttpStatus.OK);
	}
	
	@PostMapping("/friendRequest/{toId}")
	public ResponseEntity<?> friendRequest(@PathVariable String toId,HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		friendDAO.addFriendRequest(username, toId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/getpendingrequests")
	public ResponseEntity<?> getPendingRequests(HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		List<Friend> pendingRequests=friendDAO.getPendingRequests(username);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
	}
	
	@GetMapping("/getuserdetails/{fromId}")
	public ResponseEntity<?> getUserDetails(@PathVariable String formId,HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		User user=userDAO.getUserByUsername(formId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/updatependingrequest")
	public ResponseEntity<?> updatePendingRequest(@RequestBody Friend pendingRequest,HttpSession session){
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		friendDAO.updatePendingRequest(pendingRequest);//update status A/D
		return new ResponseEntity<Friend>(pendingRequest,HttpStatus.OK);
	}
	
	
	@GetMapping("/friendslist")
	public ResponseEntity<?> listOfFriends(HttpSession session){
		if(session.getAttribute("username")==null){
		error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
			
		String username=(String)session.getAttribute("username");
			List<Friend> friends=friendDAO.listOfFriends(username);
			return new ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
	}
}
