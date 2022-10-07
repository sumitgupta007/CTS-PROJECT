package com.author.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTHOR_ID")
	private int authorId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;

	@Column(name = "PASSWORD")
	private String password;

	public Author() {
	
	
	}

	public Author(String authorName, String authorEmail, String password) {

		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.password = password;
	}

	public Author(int authorId, String authorName, String authorEmail, String password) {

		this(authorName, authorEmail, password);
		this.authorId = authorId;

	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+ ", password=" + password + "]";
	}
	
}
