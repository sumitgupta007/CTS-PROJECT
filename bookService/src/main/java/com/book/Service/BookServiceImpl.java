package com.book.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.models.Book;
import com.book.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repo;

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Book SearchBookById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public Book saveBook(Book b) {
		// TODO Auto-generated method stub
		 Book book = repo.save(b);
		 System.out.println("======"+book);
		 return book;
	}

	public Book updateBook(Book b, int id) {
//		System.out.println("38============================================="+b);
		Book bo = repo.findById(id).get();
//		System.out.println("40=============================================\"+bo");
		bo.setAurhor(b.getAurhor());
		bo.setCategory(b.getCategory());
		bo.setActive(b.isActive());
		bo.setContent(b.getContent());
		bo.setEmail_id(b.getEmail_id());
		bo.setLogo(b.getLogo());
		bo.setPrice(b.getPrice());
		bo.setPublisher(b.getPublisher());
		bo.setPublished_date(b.getPublished_date());
		bo.setContent(b.getContent());
		
		return repo.save(bo);
	}

	public Book deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return repo.findById(id).get();
	}

}
