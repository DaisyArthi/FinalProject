package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.ProfilePictureDAO;
import com.niit.model.ProfilePicture;
import com.niit.model.error;

@RestController
public class ProfilePictureController {

	@Autowired
	ProfilePictureDAO profilepictureDAO;
	
	@PostMapping("/doUpload")
	public ResponseEntity<?> uploadProfilePic(@RequestParam CommonsMultipartFile image,HttpSession session){
			System.out.println(session.getAttribute("username"));
		
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		ProfilePicture profilepicture=new ProfilePicture();
		profilepicture.setUsername(username);
		profilepicture.setImage(image.getBytes());
		try{
		profilepictureDAO.save(profilepicture);
		return new ResponseEntity<ProfilePicture>(profilepicture,HttpStatus.OK);
		}catch(Exception e){
			error err=new error(6,"Unable to upload");
			return new ResponseEntity<error>(err,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
		
	@GetMapping("/getimage/{username}")
	public @ResponseBody byte[] getImage(@PathVariable String username,HttpSession session)
	{
	    if(session.getAttribute("username")==null)
		 {
				return null;
		 }
	    else
		 {
			    ProfilePicture profilePicture=profilepictureDAO.getprofilepicture(username);
			    if(profilePicture==null)
			    	return null;
		        System.out.println(profilePicture.getImage());
			    return profilePicture.getImage();
	      }
	 }

}
