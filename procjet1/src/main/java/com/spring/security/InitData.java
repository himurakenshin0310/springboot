package com.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.entity.Product;
import com.spring.entity.Type;
import com.spring.entity.User;
import com.spring.model.UserDto;
import com.spring.repository.ProductRepository;
import com.spring.repository.TypeRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InitData {

//	@Autowired
//	ProductRepository proRepo;
//
//	@Autowired
//	TypeRepository typeRepo;

	@Bean
	public CommandLineRunner initdata() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
//				List<Product> lst = new ArrayList<Product>();
//				Type type1 = typeRepo.findById((long) 1).get();
//				Type type2 = typeRepo.findById((long) 2).get();
//				for (int i = 0; i <= 50; i++) {
//					Product p = new Product();
//					p.setDescription("aaaasdasd");
//					if (i % 2 == 0) {
//						p.setEnable(true);
//						p.setImage("Bai tap 2 Thong tin khach hang.PNG");
//						p.setType(type2);
//					} else {
//						p.setEnable(false);
//						p.setImage("Bai tap 1 Thong tin hang sua.PNG");
//						p.setType(type1);
//					}
//					p.setName("product 1" + i);
//					p.setPrice(i + 10000 + i);
//					p.setQuantity(i + 1);
//					proRepo.save(p);
//				}
//				log.info("init data finished!");
			}
		};
	}
}
