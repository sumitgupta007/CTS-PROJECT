package com.book.service;



import java.util.List;

import com.book.models.Book;
//import com.book.models.Subscription;

public interface BookService {
//	@Autowired BookRepository repo;
	
	public List<Book> getAllBooks();
	public Book SearchBookById(int id);
	public Book saveNewBook(Book b);
	public Book updateBook(Book b,int id);
	public Book deleteById(int id);
//	public String saveData(Subscription sub);
		
		
	

}
