package com.reader.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.entity.Reader;
import com.reader.entity.Subscription;
import com.reader.model.Book;
import com.reader.repository.ReaderRepo;
import com.reader.repository.SubscriptionRepo;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepo repo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;

	public Subscription buySubscription(Subscription s) {

		return subscriptionRepo.save(s);

	}

	public List<Book> getALLbooks(String email) {

		Reader reader = repo.findByEmail(email);
		return null;

	}

	public Subscription findbypaymentid(int pid) {
		
		return	subscriptionRepo.findByPaymentId(pid);
	
		
	}

//	public Subscription findbybookid(int bid) {
//            Subscription bookId = subscriptionRepo.findByBookId(bid);
//		return bookId;
//	}

	public List<Subscription> getAllSubscription() {
		// TODO Auto-generated method stub
		return subscriptionRepo.findAll();
	}

	public Book findbyBookId(int bookId) {
		return null;
	}
		// TODO Auto-generated method stub
		
	

	

}
