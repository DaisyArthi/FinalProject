package com.niit.SocialColl.Modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Forum {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ForumId;
	
	@Column
	private String ForumName;
	
	@Column
	private String ForumComment;
	
	@Column
	private String UserName;
	
	@Column 
	private Date CreateDate;
	
	@Column
	private String Status;

	public int getForumId() {
		return ForumId;
	}

	public void setForumId(int forumId) {
		ForumId = forumId;
	}

	public String getForumName() {
		return ForumName;
	}

	public void setForumName(String forumName) {
		ForumName = forumName;
	}

	public String getForumComment() {
		return ForumComment;
	}

	public void setForumComment(String forumComment) {
		ForumComment = forumComment;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
}
