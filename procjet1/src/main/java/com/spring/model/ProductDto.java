package com.spring.model;

import com.spring.entity.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
	private long id;
	private String name;
	private String image;
	private double price;
	private long typeId;
	private String description;
	private String typeName;
	private boolean enable;
	
	public static ProductDto create(Product product) {
		ProductDto p = new ProductDto();
		p.setDescription(product.getDescription());
		p.setEnable(product.isEnable());
		p.setId(product.getId());
		p.setImage(product.getImage());
		p.setPrice(product.getPrice());
		p.setTypeId(product.getType().getId());
		p.setTypeName(product.getType().getName());
		p.setName(product.getName());
		return p;
	}
}
