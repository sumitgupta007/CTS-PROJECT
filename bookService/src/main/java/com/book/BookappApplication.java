package com.book;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.models.Book;
import com.book.repository.BookRepository;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {
	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		repository.saveAll(Arrays.asList(new Book(1, "logo1", "Spiderman is back", "comic", 200, "rohan", "Moon publisher", "22/04/2022", "content", true, "rohan@gmail"),
				          new Book(2, "logo2", "hulk is back", "comic", 300, "emily", "sun publisher", "20/05/2020", "content", true, "emilyn@gmail") ) );
		
	}

}
