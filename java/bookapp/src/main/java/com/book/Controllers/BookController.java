package com.book.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.Service.BookServiceImpl;
import com.book.models.Book;
import com.book.repository.BookRepository;

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
		 Book book2 = bookSerImpl.saveBook(book);
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

}
