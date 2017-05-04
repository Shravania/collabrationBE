/*package com.niit.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BlogPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date createdOn;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="created_by_id")
	private User created By

}
*/