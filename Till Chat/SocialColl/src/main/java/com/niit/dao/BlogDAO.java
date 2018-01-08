package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public void addblog(Blog blog);
	
	public List<Blog> getlist(int approved);
	
	public void updateblog(Blog blog);
	
	public void deleteblog(Blog blog);
	
	public Blog getblog(int id);
}
