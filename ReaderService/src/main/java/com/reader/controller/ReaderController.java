package com.reader.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.reader.Service.ReaderService;
import com.reader.entity.ErrorMesages;
import com.reader.entity.Subscription;
import com.reader.exception.ReaderException;
import com.reader.model.Book;

@RestController
@RequestMapping("/api/v1/digitalbooks/readers")
public class ReaderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ReaderService readerServ;

//	@Autowired
//	private ReaderClient client;
	
//	1reader can search book
//	@GetMapping("/all")
//	public List<Book> searchBooks() {
//		Book booklist =(Book) restTemplate.getForObject("http://localhost:8080/api/v1/digitalbooks/books/", List.class);
//		return (List<Book>) booklist;
//		
//	}
	
//2.reader can buy book
	@PostMapping("/buy")
	public Subscription buyBooks(@RequestBody Subscription sub) {
		System.out.println("readercontroller=======================================");

		return readerServ.buySubscription(sub);

	}
	@GetMapping("/")
	public List<Subscription> getAll() {
	return	readerServ.getAllSubscription();
		
	}

	@GetMapping("/{email}")
	public Book getBookByEmail(@PathVariable String email) {

//		Book b = restTemplate.exchange(localhost:8080/api/v1/digitalbooks/books/email, HttpMethod.GET, null, String.class, Book.class).getbody();

//		Book book = restTemplate.getForObject("localhost:8080/api/v1/digitalbooks/books?emailid=email", Book.class);
		Book book2 = restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books/" + email + "/email",
				Book.class);
		System.out.println("===============================" + book2);
//		 Book b = client.getbookbyemail();
		return book2;
	}
//	reader can find purchased book by paymentId 
	@GetMapping("/email/books/{pid}")
	public Subscription findAllpurchasedBooks(@PathVariable int pid) {
		return readerServ.findbypaymentid(pid);

	}

//	reader can read book 
	@GetMapping("/emailId/books/{bid}")
	public Book readBook(@PathVariable int bid) {
		System.out.println("===========readercontroller=============");
//		
		Book book = restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books/" + bid, Book.class);
		System.out.println("========================="+book);
		return book;
	}

//	reader can ask for refund within 24 hrs of payment 
	@GetMapping("/{bid}/refund")
	public boolean elligbleForRefund(@PathVariable int bid) throws ParseException {
		Book book = restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books/" + bid, Book.class);
		String sdate =book.getPublished_date();
		Date actualDate=new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		Calendar today = Calendar.getInstance();
		if (today.after(actualDate)) {
			return true;
			
		}else {
			return false;
		}
		
		
	}
	
//	@ExceptionHandler(ReaderException.class)
//	public String handleReaderException(ReaderException me) {
//		return "ReaderException: "+me.getMessage();
//	}
//	
//	
//	@ExceptionHandler(ReaderException.class)
//	public ErrorMesages  handleReaderException1(ReaderException me) {
//		return new ErrorMesages(
//			"ReaderException: "+me.getMessage(), 
//			me.getClass().toString(), 
//			"Something bad happened, please try after some time"
//		);
//	}

}
