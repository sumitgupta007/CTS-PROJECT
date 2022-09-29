package com.book.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	int author_Id;
	private	String name;
	private String email;
	public int getAuthor_Id() {
		return author_Id;
	}
	public void setAuthor_Id(int author_Id) {
		this.author_Id = author_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Author(int author_Id, String name, String email) {
		super();
		this.author_Id = author_Id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Author [author_Id=" + author_Id + ", name=" + name + ", email=" + email + "]";
	}
	

}
