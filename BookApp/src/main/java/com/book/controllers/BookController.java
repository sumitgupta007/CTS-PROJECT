package com.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.exception.BookException;
import com.book.models.Book;
import com.book.models.ErrorMesages;
//import com.book.models.Subscription;
import com.book.service.BookServiceImpl;


@RestController()
@RequestMapping("/api/v1/digitalbooks/books")
public class BookController {
	
	
	@Autowired
	private BookServiceImpl bookSerImpl;
	
	@GetMapping()
	public List<Book> getAllBooks() {
		
		return bookSerImpl.getAllBooks();
		
	}
	@GetMapping("/{id}")
	public Book searchSingleBook(@PathVariable int id) {
		return bookSerImpl.SearchBookById(id);
		
	}
	@PostMapping()
	public Book saveBook(@RequestBody Book book) {
		 Book book2 = bookSerImpl.saveNewBook(book);
		 System.out.println(book2);
		 return book2;
		
	}
	@PutMapping("/up/{id}")	
	public Book updateBook(@RequestBody Book book,@PathVariable int id) {
//		System.out.println("-----------------------------------------------------------"+id);
		return bookSerImpl.updateBook(book, id);
		
	}
	@DeleteMapping("/{id}")
	public Book deleteById(@PathVariable int id) {
		return bookSerImpl.deleteById(id);
	}
	
//	/api/v1/digitalbooks/books/buy 
//	@PostMapping("/buy")
//	public Subscription buyBook(@RequestBody Subscription sub) {
//		return bookSerImpl.saveBook(sub); 
	
	
	
//	/api/v1/digitalbooks/books/search?category&author&price&publisher 
	@GetMapping("/search")
	public List<Book> getBooks(@RequestParam("category") String category, 
							   		  
							         @RequestParam("price") double price, 
							         @RequestParam("publisher") String publisher){
		return bookSerImpl.getBooks(category, price,publisher);
	}
	
	//--------------------------------exception--------------------------
	
	
	@ExceptionHandler(BookException.class)
	public String handleBookException(BookException me) {
		return "BookException: "+me.getMessage();
	}
	
	
	@ExceptionHandler(BookException.class)
	public ErrorMesages  handleMovieException(BookException me) {
		return new ErrorMesages(
			"BookException: "+me.getMessage(), 
			me.getClass().toString(), 
			"Something bad happened, please try after some time"
		);
	}
	
	
	
	
	
	
	
	

}
