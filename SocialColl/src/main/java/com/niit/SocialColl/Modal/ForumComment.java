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
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ForumCommentId;
	
	@Column
	private int ForumId;
	
	@Column
	private String Comment;
	
	@Column
	private Date CommentDate;
	
	@Column
	private String UserName;
	
	@Column
	private String Name;

}
