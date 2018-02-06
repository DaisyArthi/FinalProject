package com.niit.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Forum {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	
	@Column
	private String forumName;
	
	@Lob 
	private String forumComment;
	
	@Column
	private boolean Forumapproved;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumComment() {
		return forumComment;
	}

	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}

	public boolean isForumapproved() {
		return Forumapproved;
	}

	public void setForumapproved(boolean forumapproved) {
		Forumapproved = forumapproved;
	}
	
	
}
