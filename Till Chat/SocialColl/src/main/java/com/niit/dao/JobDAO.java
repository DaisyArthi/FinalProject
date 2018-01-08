package com.niit.dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO {

	public void addjob(Job job);
	
	public List<Job> getAllJobs();
	
	public Job getJob(int jobId);
}
