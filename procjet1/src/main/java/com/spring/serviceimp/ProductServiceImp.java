package com.spring.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.entity.Product;
import com.spring.model.ProductDto;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository prodRepo;

	@Override
	public List<ProductDto> findAllDto() {
		return prodRepo.findAll().parallelStream().map(ProductDto::create).collect(Collectors.toList());
	}

	@Override
	public Page<Product> productPage(Pageable paging) {
		return prodRepo.findAll(paging);		
	}

	@Override
	public Page<Product> searchByNameAndType(Pageable page, String name, int id) {
		return prodRepo.searchByNameAndType(id, name, page);
	}

}
