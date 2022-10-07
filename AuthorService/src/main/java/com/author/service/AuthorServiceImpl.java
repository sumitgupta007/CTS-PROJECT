package com.author.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.author.dto.LoginDTO;
import com.author.entity.Author;
import com.author.exceptions.DigitalBookException;
import com.author.repository.AuthorRepo;
//import com.cts.digitalbook.digitalbookauthorservice.entities.AuthorEntity;
@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepo authorRepo;

	@Override
	public Author registerAuthorService(Author author) throws DigitalBookException {
		if (!author.getAuthorEmail().isEmpty() && !author.getPassword().isEmpty()
				&& !author.getAuthorName().isEmpty()) {

			Optional<Author> optionalAuthor = authorRepo.findByAuthorEmail(author.getAuthorEmail());
			if (optionalAuthor.isEmpty()) {

				Author newAuthorEntity = new Author();

				newAuthorEntity.setAuthorEmail(author.getAuthorEmail().toLowerCase());
				newAuthorEntity.setAuthorName(author.getAuthorName());
				newAuthorEntity.setPassword(author.getPassword());
System.out.println("line33======================"+newAuthorEntity);
				return authorRepo.save(newAuthorEntity);

			} else {
				throw new DigitalBookException(
						"Author Email-ID id already Exits. Please use the other or create new account. Thank You !");

			}
		} else {

			throw new DigitalBookException(
					"Author Registration Failed. PLease fill all the fileds like Name, EmailID, Password. Thank You !!!");

		}
		
	}

	@Override
	public Author authorLogin(LoginDTO authorLoginDTO) throws DigitalBookException {
		Optional<Author> optionalAuthor = authorRepo
				.findByAuthorEmail(authorLoginDTO.getAuthorEmail().toLowerCase());

		if (!optionalAuthor.isEmpty()) {
			if (optionalAuthor.get().getPassword().equals(authorLoginDTO.getPassword())) {
				return optionalAuthor.get();
			} else {
				throw new DigitalBookException("Please enter the correct password.");
			}
		} else {
			throw new DigitalBookException("Author Not Registered. Please register Author");
		}
	}

	@Override
	@Cacheable(key = "#authorId",value = "authorIdStore")
	public Optional<Author> getAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return authorRepo.findById(authorId);
	}

	@Override
	@Cacheable(key = "#authorName",value = "authorNameStore")
	public Optional<Author> getAuthorByName(String authorName) {
		// TODO Auto-generated method stub
		return authorRepo.findAuthorByAuthorName(authorName);
	}

	@Override
	public Author createNewAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepo.save(author);
	}

	@Override
	public Author updateAuthorDetails(int authorId) {

		Author  auth=new Author();
             Author a = authorRepo.findById(authorId).get();
             auth.setAuthorEmail(a.getAuthorEmail());
             auth.setAuthorId(authorId);
             auth.setAuthorName(a.getAuthorName());
             auth.setPassword(a.getPassword());
             
		return auth;
	}

}
