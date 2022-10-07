package com.author.service;

import java.util.Optional;

import com.author.entity.Author;
import com.author.exceptions.DigitalBookException;
//import com.cts.digitalbook.digitalbookauthorservice.dtos.AuthorLoginDTO;
//import com.cts.digitalbook.digitalbookauthorservice.entities.AuthorEntity;

public interface AuthorService {

	public Author registerAuthorService(Author author) throws DigitalBookException;

	public Author authorLogin(com.author.dto.LoginDTO authorLoginDTO) throws DigitalBookException;

	public Optional<Author> getAuthorById(int authorId);

	public Optional<Author> getAuthorByName(String authorName);

	public Author createNewAuthor(Author author);

	public Author updateAuthorDetails(int authorId);

}
