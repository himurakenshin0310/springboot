package com.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Product;
import com.spring.repository.ProductRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CartService {
	@Autowired
	ProductRepository productRepo;

	private Map<Integer, Integer> cart = new Hashtable<>();

	public void insert(int id, int quantity) {
		if (cart.containsKey(id))
			cart.replace(id, cart.get(id) + quantity);
		else
			cart.put(id, quantity);
	}

	public void update(int id, int quantity) {
		if (cart.containsKey(id)) {
			cart.replace(id, quantity);
		} else
			return;
	}

	public void remove(int id) {
		cart.remove(id);
	}

	public List<cartProduct> content() {
		List<cartProduct> lst = new ArrayList<cartProduct>();
		for (int i : cart.keySet()) {
			Product pd = productRepo.findById((long) i).get();
			cartProduct p = new cartProduct();
			p.setId(pd.getId());
			p.setImage(pd.getImage());
			p.setName(pd.getName());
			p.setPrice(pd.getPrice());
			p.setQuantity(cart.get(i));
			lst.add(p);
		}
		return lst;
	}

	public Set<Product> listProduct() {
		Set<Product> lst = new HashSet<Product>();
		for (int i : cart.keySet()) {
			Product p = productRepo.findById((long) i).get();
			lst.add(p);
		}
		return lst;
	}

	public double totalPrice() {
		double sum = 0;
		for (int s : cart.keySet()) {
			sum += (productRepo.findById((long) s).get().getPrice() * cart.get(s));
		}
		return sum;
	}

	public cartProduct getOne(int key) {
		cartProduct c = new cartProduct();
		Product p = productRepo.findById((long) key).get();
		c.setId(key);
		c.setImage(p.getImage());
		c.setName(p.getName());
		c.setPrice(p.getPrice());
		c.setQuantity(cart.get(key));
		return c;
	}

	@Setter
	@Getter
	class cartProduct {
		private long id;
		private String name;
		private String image;
		private double price;
		private int quantity;
	}
}
