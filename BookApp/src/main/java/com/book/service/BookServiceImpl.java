package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.models.Book;
//import com.book.models.Subscription;
import com.book.repository.BookRepository;
//import com.book.repository.SubscriptionRepository;

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

	public Book saveNewBook(Book b) {
		// TODO Auto-generated method stub
		Book book = repo.save(b);
		System.out.println("======" + book);
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

	
	public List<Book> getBooks(String category, String authorName, double price, String publisher) {
		List<Book> booksList = new ArrayList();
//		Optional<AuthorModel> authorEntity = null;

		if (category != null && authorName != null && price != 0 && publisher != null) {
//			authorEntity = authorServiceClient.getAuthorByName(authorName);

			booksList = repo.findbycap(category,  price, publisher);

		} else
			return null;

		return booksList;
	}

	public List<Book> getBooks(String category, double price, String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

//	public String saveData(BuyBook book) {
//		int bId = book.getBookId();
//		String str = repo.findByBookName(bId);
//		int a = ThreadLocalRandom.current().nextInt();
//		int d = Math.abs(a);
//		System.out.println("random number " + d);
//		book.setGeneratedId(d);
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date = new Date();
//		book.setDate(formatter.format(date));
//		buyRepo.save(book);
//		
//		return "you have successfully purchased book and your book id is " + d;

}
