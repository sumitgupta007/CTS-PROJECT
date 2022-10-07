package com.author.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.entity.Author;


public interface AuthorRepo extends JpaRepository<Author, Integer> {

//	Optional<Author> findByEmailId(String authorEmail);

	Optional<Author> findAuthorByAuthorName(String authorName);

	Optional<Author> findByAuthorEmail(String authorEmail);

}
