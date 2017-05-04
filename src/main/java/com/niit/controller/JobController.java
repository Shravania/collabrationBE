package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.JobDAO;
import com.niit.model.Job;
import com.niit.model.User;
import com.niit.model.Error;

@RestController
public class JobController {
@Autowired
private JobDAO jobDAO;
@RequestMapping(value="/addJob",method=RequestMethod.POST)
public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
	System.out.println("hi..");
     User user=(User)session.getAttribute("user");
     System.out.println("hello");
     /*if(user==null){
    	 
     Error error=new Error(3,"Unauthorized user");
     
     return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
}
else{*/
     String role=user.getRole();
     System.out.println("how r u");
     if(role.equals("Admin")){
    	 System.out.println("i am meeting");
     job.setPostedOn(new Date());
     System.out.println("c u later");
     job.setActive(true);
     System.out.println("bye");
     jobDAO.saveJobDetails(job);
     System.out.println("call u back");
     return new ResponseEntity<Void>(HttpStatus.OK);
}
else{
     Error error=new Error(4,"Access Denied");
     return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
}
}

@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
public ResponseEntity<?> getAllJobs(HttpSession session){
      User user=(User)session.getAttribute("user");
      if(user==null){
      Error error=new Error(3,"Unauthorized user");
      return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
}
      List<Job> jobs=jobDAO.getAllJobDetails();
      return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
}

@RequestMapping(value="/getJob/{id}",method=RequestMethod.GET)
public ResponseEntity<?> getJobById(@PathVariable int id,HttpSession session){
       User user=(User)session.getAttribute("user");
     if(user==null){
     Error error=new Error(3,"Unauthorized user");
     return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
}
Job job=jobDAO.getJobById(id);
return new ResponseEntity<Job>(job,HttpStatus.OK);
}



}