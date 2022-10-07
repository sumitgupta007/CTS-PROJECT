package com.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reader.entity.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {

	Subscription findByPaymentId(int pid);

//	Subscription findByBookId(int bid);

}
