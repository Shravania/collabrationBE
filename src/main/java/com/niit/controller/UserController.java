package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.model.User;
import com.niit.DAO.UserDAO;
import com.niit.model.Error;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
   public ResponseEntity<?> registerUser(@RequestBody User user){
		try{
			user.setEnabled(true);
			user.setOnline(false);
			User savedUser=userDAO.registerUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}catch(Exception e){
		e.printStackTrace();
		Error error=new Error(2,"Coludnt insert user details.Cannot have null/duplicate values");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
	User validUser=userDAO.login(user);
	if(validUser==null){
		Error error=new Error(3,"Invalid credentials..please enter valid username and password");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	else{ 
		session.setAttribute("user",validUser);
		validUser.setOnline(true);
		userDAO.updateUser(validUser);
		return new ResponseEntity<User>(validUser,HttpStatus.OK);
		
	}
	}
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){ //unauthorized user
			Error error=new Error(3,"Unauthorized user..Please Login..");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			
		}
		else{
			user=userDAO.getUser(user.getUserid());
			user.setOnline(false);
			userDAO.updateUser(user);
			session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	public ResponseEntity<?> getUser(HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
			Error error=new Error(3,"Unauthorized user..");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		
	}
	else{
		userDAO.getUser(user.getUserid());
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
	@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User updatedUserDetails,HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
			Error error=new Error(3,"Unauthorized user..");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{
			userDAO.updateUser(updatedUserDetails);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
}
