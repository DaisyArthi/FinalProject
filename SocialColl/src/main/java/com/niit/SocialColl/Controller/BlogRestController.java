package com.niit.SocialColl.Controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialColl.Dao.BlogDAO;




@RestController
public class BlogRestController {

	@Autowired
    BlogDAO blogdao;
	
	
}
