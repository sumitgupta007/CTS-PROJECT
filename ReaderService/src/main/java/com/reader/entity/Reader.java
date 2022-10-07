package com.reader.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int readerId;
	private String name;
	private String email;
	private int bookid;

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
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

	public Reader() {

	}

	public Reader(int readerId, String name, String email) {
		super();
		this.readerId = readerId;
		this.name = name;
		this.email = email;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", name=" + name + ", email=" + email + ", bookid=" + bookid + "]";
	}

	

	
	
	

	

}
