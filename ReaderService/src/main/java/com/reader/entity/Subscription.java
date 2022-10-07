package com.reader.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private int readerId;
	private String readerName;
	private String bookName;
	public Subscription(int paymentId, int readerId, String readerName, String bookName) {
		super();
		this.paymentId = paymentId;
		this.readerId = readerId;
		this.readerName = readerName;
		this.bookName = bookName;
	}
	public Subscription() {
		
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "Subscription [paymentId=" + paymentId + ", readerId=" + readerId + ", readerName=" + readerName
				+ ", bookName=" + bookName + "]";
	}
	
	
	

}
