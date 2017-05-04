/*package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.niit.DAO.BlogDAO;
import com.niit.model.BlogPost;
import com.niit.model.Error;
import com.niit.model.User;

@Controller
public class BlogPostController {
	@Autowired
	private BlogDAO blogDAO;
	public ResponseEntity<?> saveBlogPost(BlogPost blogpost,HttpSession session)
	
	User user=(User)session.getAttribute("user");
	if(user==null){
	Error error=new Error(3,"Unauthorized user");
	return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	else{
		blogDAO.saveBlogPost(blogPost)
	}
}
*/