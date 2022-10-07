package com.book.Service;

import java.util.List;

import com.book.models.Book;

public interface BookService {
//	@Autowired BookRepository repo;
	
	public List<Book> getAllBooks();
	public Book SearchBookById(int id);
	public Book saveBook(Book b);
	public Book updateBook(Book b,int id);
	public Book deleteById(int id);
		
		
	

}
