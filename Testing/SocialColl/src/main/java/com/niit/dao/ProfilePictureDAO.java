package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDAO {

	public void save(ProfilePicture profilepicture);
	
	public ProfilePicture getprofilepicture(String username);
}
