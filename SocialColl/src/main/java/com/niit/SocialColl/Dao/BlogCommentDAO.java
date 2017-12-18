package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.BlogComment;

public interface BlogCommentDAO {

	public void addBlogComment(BlogComment blogcomment);
	
	public List<BlogComment> getBlogCommentList();
}
