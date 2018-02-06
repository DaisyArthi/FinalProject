package com.niit.controller;

import java.util.Date;
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

import com.niit.dao.JobDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Job;
import com.niit.model.error;

@RestController
public class JobController {

	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	UserDAO userDAO;
	

	@GetMapping(value="/getALlJobs")
	public List<Job> getAllJobs()
	{
		return jobDAO.getAllJobs();
	}
	
	@PostMapping("/addjob")
	public ResponseEntity<?> addjob(@RequestBody Job job,HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		userDAO.getUserByUsername(username);
		job.setPostDate(new Date());
		jobDAO.addjob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}

	
	@GetMapping("/getJob/{jobId}")
	public ResponseEntity<?> getJob(@PathVariable int jobId,HttpSession session)
	{
		if(session.getAttribute("username")==null){
			error err=new error(5,"UnAuthroized User");
			return new ResponseEntity<error>(err,HttpStatus.UNAUTHORIZED);
		}
		Job jobs = jobDAO.getJob(jobId);
		return new ResponseEntity<Job>(jobs,HttpStatus.OK);
	}
}
