package com.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reader.entity.Reader;
import com.reader.entity.Subscription;

public interface ReaderRepo extends JpaRepository<Reader, Integer> {

	Subscription save(Subscription s);
	Reader findByEmail(String email);

}
