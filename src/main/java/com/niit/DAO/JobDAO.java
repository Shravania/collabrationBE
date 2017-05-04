package com.niit.DAO;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO {
	public void saveJobDetails(Job job);
	public List<Job> getAllJobDetails();
	public Job getJobById(int id);

}
