package com.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.controller.BackendController;
import com.spring.entity.OrderDetail;
import com.spring.entity.Product;
import com.spring.entity.Type;
import com.spring.repository.Order;
import com.spring.repository.OrderDetailRepository;
import com.spring.repository.ProductRepository;
import com.spring.repository.TypeRepository;
import com.spring.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

	@InjectMocks
	BackendController backendcontroller;

	@Autowired
	ProductRepository proRepo;

	@Autowired
	TypeRepository typeRepo;

	@org.junit.Test
	public void test() {
		List<Product> list = proRepo.findAll();
		assertThat(backendcontroller).isNotNull();
	}

	@org.junit.Test
	public void findByIdShouldReturnObject() {
		assertThat(proRepo.findById((long) 52)).isNotNull();
	}

	@org.junit.Test
	public void searchByNameAndTypeIdShouldReturnValue() {
//		assertThat(proRepo.searchByNameAndType("product", 1, PageRequest.of(0, 1))).isNotNull();
//		Page<Product> p =proRepo.searchByNameAndType("product", 1, PageRequest.of(0, 5));
	}

	@Autowired
	Order orderRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;

	@org.junit.Test
	public void insertOrderAndOrderDetailShouldSuccsess() {
//		com.spring.entity.Order order = new com.spring.entity.Order();
//		order.setTotalPrice(5555);
//		order.setUserOrder(userRepo.findById(2l).get());
//		orderRepo.save(order);
//		OrderDetail orderDetail = new OrderDetail();
//		orderDetail.setOrder(orderRepo.findById(1l).get());
//		orderDetail.setProducts(proRepo.findById(1l).get());
//		orderDetailRepo.save(orderDetail);
	}
}
