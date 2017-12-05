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
public class Blog {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BlogId;
	
	@Column
	private String BClogName;
	
	@Column
	private String BlogContent;
    
    @Column
    private int UserName;
  
    @Column
    private Date CreateDate;

    @Column
    private String Status;
  
    @Column
    private int Likes;

	public int getBlogId() {
		return BlogId;
	}

	public void setBlogId(int blogId) {
		BlogId = blogId;
	}

	public String getBClogName() {
		return BClogName;
	}

	public void setBClogName(String bClogName) {
		BClogName = bClogName;
	}

	public String getBlogContent() {
		return BlogContent;
	}

	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}

	public int getUserName() {
		return UserName;
	}

	public void setUserName(int userName) {
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

	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}
    
    
}
