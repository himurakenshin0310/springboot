package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.entity.Product;
import com.spring.model.ProductDto;

public interface ProductService {
	List<ProductDto> findAllDto();
	Page<Product> productPage(Pageable paging);
	
	Page<Product> searchByNameAndType(Pageable page, String name, int id);
}
