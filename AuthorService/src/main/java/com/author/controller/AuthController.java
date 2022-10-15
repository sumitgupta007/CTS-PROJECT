package com.author.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.author.dto.Book;
import com.author.dto.LoginDTO;
import com.author.dto.ResponseDTO;
import com.author.entity.Author;
import com.author.service.AuthorService;
//import com.cts.digitalbook.digitalbookauthorservice.controllers.AuthorService;
//import com.cts.digitalbook.digitalbookauthorservice.controllers.DigitalBookException;
//import com.cts.digitalbook.digitalbookauthorservice.entities.AuthorEntity;

@RestController
@RequestMapping("/api/v1/digitalbooks/author")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
//	public ResponseDTO registerAuthor(@RequestBody Author author) {
//		
//		ResponseDTO responseDto = new ResponseDTO();
//
//		try {
//			Author authorEntity2 = authorService.registerAuthorService(author);
//			responseDto.setResult(authorEntity2);
//			responseDto.setMessage("Author Registered Successfully...");
//		} catch (com.author.exceptions.DigitalBookException e) {
//			responseDto.setException(e.getMessage());
//		}
//
//		return responseDto;
		
//	}
	
	@PostMapping("/login") // author can login 
	public ResponseDTO loginAuthor(@RequestBody LoginDTO loginDTO) {
		ResponseDTO responseDto = new ResponseDTO();

		try {
			Author author = authorService.authorLogin(loginDTO);
			responseDto.setResult(author);
			responseDto.setMessage("Author Login successfully");
		} catch (com.author.exceptions.DigitalBookException e) {
			responseDto.setException(e.getMessage());
		}

		return responseDto;
	}
	//author create account.
//	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
	public Author createAuthor(@RequestBody Author author) {
		return authorService.createNewAuthor(author);
		
	}
	
	//author can make any changes:
	@PutMapping("/updateauthentity{authorId}")
	public Author updateBlockUNblockBookHist(@PathVariable int authorId) {
		Author author = authorService.updateAuthorDetails(authorId);
		return author;
		
		
	}
	@PutMapping("/updatebookentity/{bookId}")
	public String updateBlockUNblockBookHist(@PathVariable Boolean bookId) {
//		authorService.updateAuthorDetails(authorId);
		Book book = restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books/"+bookId, Book.class);
		Book book2=new Book();
		book2.setActive(book.isActive());
		Book b=restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books/up/"+bookId, Book.class);
		return "Update Successfull";


}
//	author can create book
	@GetMapping("/")
	public String createBook(Book book) {
		
		Book book1 = restTemplate.getForObject("http://localhost:9090/api/v1/digitalbooks/books", Book.class);
		return "New Book Created";
		
	}
	
}
