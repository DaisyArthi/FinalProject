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
public class BlogComment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BlogCommentId;
	
	@Column
	private int BlogId;
	
	@Column
	private String Comment;
	
	@Column
	private Date CommentDate;
	
	@Column
	private String UserName;
	
	@Column
	private String Name;

	public int getBlogCommentId() {
		return BlogCommentId;
	}

	public void setBlogCommentId(int blogCommentId) {
		BlogCommentId = blogCommentId;
	}

	public int getBlogId() {
		return BlogId;
	}

	public void setBlogId(int blogId) {
		BlogId = blogId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Date getCommentDate() {
		return CommentDate;
	}

	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	
}
