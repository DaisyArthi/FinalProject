package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.Blog;


public interface BlogDAO {

	public void addBlog(Blog blog);
	
    public List<Blog> getListBlog();
	
	public void updateBlog(Blog blog);
	
	public void deleteBlog(int BlogId); 
	
	public Blog getBlog(int BlogId);
	
	public void approveBlog(Blog blog);
}
