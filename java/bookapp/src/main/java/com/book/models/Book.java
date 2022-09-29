package com.book.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int book_id;
	
   private String logo;
   private String title;
   private  String category;
   private  double price;
   private  String aurhor;
   private  String publisher;
   private  String published_date;
   private  String content;
   private  boolean active;
   private  String  email_id;
   	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public String getEmail_id() {
		return email_id;
	}
	public Book(int book_id, String logo, String title, String category, double price, String aurhor, String publisher,
			String published_date, String content, boolean active, String email_id) {
		this.book_id = book_id;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.aurhor = aurhor;
		this.publisher = publisher;
		this.published_date = published_date;
		this.content = content;
		this.active = active;
		this.email_id = email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAurhor() {
		return aurhor;
	}
	public void setAurhor(String aurhor) {
		this.aurhor = aurhor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublished_date() {
		return published_date;
	}
	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", logo=" + logo + ", title=" + title + ", category=" + category
				+ ", price=" + price + ", aurhor=" + aurhor + ", publisher=" + publisher + ", published_date="
				+ published_date + ", content=" + content + ", active=" + active + ", email_id=" + email_id + "]";
	}
	public Book() {		
	}
	
	
    
}
