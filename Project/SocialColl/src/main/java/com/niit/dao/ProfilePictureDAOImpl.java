package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.ProfilePicture;

@Repository
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO{

	@Autowired
    private SessionFactory sessionFactory;

	
	public void save(ProfilePicture profilepicture) {
		
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilepicture);
		
	}

	
	public ProfilePicture getprofilepicture(String username) {
		Session session= sessionFactory.getCurrentSession();
		ProfilePicture profilepicture = (ProfilePicture)session.get(ProfilePicture.class,username);
		return profilepicture;
	}
	
	
	
}
