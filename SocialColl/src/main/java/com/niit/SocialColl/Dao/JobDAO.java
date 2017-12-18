package com.niit.SocialColl.Dao;

import java.util.List;


import com.niit.SocialColl.Modal.Job;

public interface JobDAO {

	public void addJob(Job job);
	
	public List<Job> getJobList();
	
	public void deleteJob(Job job);
}
