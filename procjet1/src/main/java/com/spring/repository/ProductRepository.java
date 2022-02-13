package com.spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p")
	Page<Product> findAll(Pageable paging);
	
	@Query(value = "SELECT * from product JOIN(`type`) ON(product.type = type.id) WHERE type.id = :id and product.name like %:name%",
			countQuery = "SELECT count(*) from product JOIN(`type`) ON(product.type = type.id) WHERE type.id = :id and product.name like %:name%",
			nativeQuery = true)
	Page<Product> searchByNameAndType(@Param("id") Integer id, @Param("name") String name, Pageable paging);
}
