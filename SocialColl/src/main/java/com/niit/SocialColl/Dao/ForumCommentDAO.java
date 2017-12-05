package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.ForumComment;



public interface ForumCommentDAO {

    public void addForumc(ForumComment forumcomment);
    
	public List<ForumComment> getList();
	
	public void updateForumc(ForumComment forumcomment);
	
	public ForumComment getForumc(int ForumCommentId);
	
	public void deleteForumc(int ForumCommentId);

}
