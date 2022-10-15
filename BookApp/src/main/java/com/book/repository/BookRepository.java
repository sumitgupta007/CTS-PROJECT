package com.book.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select D from Book D where D.category=?1  and price=?2 and publisher=?3")
	List<Book> findbycap(String category, double price, String publisher);

}
