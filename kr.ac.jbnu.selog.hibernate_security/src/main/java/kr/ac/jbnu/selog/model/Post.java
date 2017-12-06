package kr.ac.jbnu.selog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
	
	@Id
	@Column(name="post_key")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int post_key;
	
	@Column(name="post_title")
	private String post_title;
	
	@Column(name="post_content")
	private String post_content;
	
	@Column(name="post_visible")
	private int post_visible;
	
	@Column(name="post_owner")
	private String post_owner;
	
	public int getPost_key() {
		return post_key;
	}
	
	public void setPost_key(int key) {
		this.post_key = key;
	}
	
	public String getPost_title() {
		return post_title;
	}
	
	public void setPost_title(String title) {
		this.post_title = title;
	}
	
	public String getPost_content() {
		return post_content;
	}
	
	public void setPost_content(String content) {
		this.post_content = content;
	}
	
	
	public int getPost_visible() {
		return post_visible;
	}
	
	public void setPost_visible(int v) {
		this.post_visible = v;
	}
	
	public String getPost_owner() {
		return post_owner;
	}
	
	public void setPost_owner(String owner) {
		this.post_owner = owner;
	}
	
	@Override
	public String toString() {
		return "Post's key_info =" + post_key + "post_title = " + post_title + "post_content = " + post_content + "post_visible = " + post_visible + "post_owner = " + post_owner;
	}

}
