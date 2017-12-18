package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.Blog;


public interface BlogDAO {

	public void addBlog(Blog blog);
	
	public List<Blog> getBlogList();
	
	public void deleteBlog(Blog blog);
	
	public Blog getBlog(int BlogID);
	
	public void updateBlog(Blog blog);
	
	public boolean approveBlog(Blog blog);
}
