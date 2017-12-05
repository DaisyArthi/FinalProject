package com.niit.SocialColl.Modal;



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
public class Friend {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int FriendId;
	
	@Column
	private String UserName;
	
	@Column
	private String Status;

	public int getFriendId() {
		return FriendId;
	}

	public void setFriendId(int friendId) {
		FriendId = friendId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
}
