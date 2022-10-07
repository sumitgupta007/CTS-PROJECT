package com.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.reader.repository.SubscriptionRepo;

@SpringBootApplication
//@EnableFeignClients
//@EnableJpaRepositories(basePackageClasses = ReaderRepo.class)
public class ReaderServiceApplication  {
	
	
	private SubscriptionRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(ReaderServiceApplication.class, args);
	}

	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}



//	@Override
//	public void run(String... args) throws Exception {
//		
//		repo.saveAll(Arrays.asList(new Subscription(1, 1, "sumit", "book1"),
//				new Subscription(2, 2, "vikas", "book2"),
//				new Subscription(3, 3, "nikhil", "book3")));
//	}
}
