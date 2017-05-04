/*package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blogcomment_batch15")
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private User commentedBy;
	private Date commentedOn;
	@ManyToOne
	@JoinColumn(name="user_id")
	private BlogPost blogpost;
	private String body;
	 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public User getCommentedBy() {
			return commentedBy;
		}
		public void setCommentedBy(User commentedBy) {
			this.commentedBy = commentedBy;
		}
		public Date getCommentedOn() {
			return commentedOn;
		}
		public void setCommentedOn(Date commentedOn) {
			this.commentedOn = commentedOn;
		}
		public BlogPost getBlogpost() {
			return blogpost;
		}
		public void setBlogpost(BlogPost blogpost) {
			this.blogpost = blogpost;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
	

}
*/