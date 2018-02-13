package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public boolean addblog(Blog blog);
	
    public List<Blog> getlist();
	
	public boolean updateblog(Blog blog);
	
	public boolean deleteblog(Blog blog);
	
	public Blog getblog(int id);
	
	public boolean approveBlog(Blog blog);
	
	public boolean  rejectBlog(Blog blog);
	
	public boolean incLike(Blog blog);
}
