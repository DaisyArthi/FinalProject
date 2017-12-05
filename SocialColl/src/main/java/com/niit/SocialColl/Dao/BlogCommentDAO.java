package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.BlogComment;


public interface BlogCommentDAO {
	
	public void addBlogc(BlogComment blogcomment);
    
	public List<BlogComment> getList();
	
	public void updateBlogc(BlogComment blogcomment);
	
	public BlogComment getBlogc(int BlogCommentId);
	
	public void deleteBlogc(int BlogCommentId);

}
