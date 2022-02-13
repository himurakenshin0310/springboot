package com.spring.controller;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.ProductDto;
import com.spring.repository.ProductRepository;
import com.spring.service.CartService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class CartController {

	@Autowired
	HttpSession session;

	@Autowired
	CartService cartService;

	@Autowired
	ProductRepository productRepo;

	@GetMapping("cart")
	public String cart(Model model) {
		return "frontend/cart";
	}

	@PostMapping("add-cart")
	public ModelAndView addcart(Model model, @RequestParam int id, @RequestParam int quantity) {
		cartService.insert(id, quantity);
		session.setAttribute("cart", cartService);
		return new ModelAndView("redirect:/cart");
	}

	@GetMapping("removeitem")
	public ModelAndView removeItem(@RequestParam(name = "id[]") int[] id) {
		for (int i : id) {
			cartService.remove(i);
		}
		return new ModelAndView("redirect:/cart");
	}
	

	@ResponseBody
	@GetMapping("updateitem")
	public Map<String, Object> updateCart(@RequestParam int id, int quantity) {
		cartService.update(id, quantity);
		Map<String, Object> json = new Hashtable<String, Object>();
		json.put("total", cartService.totalPrice());
		json.put("cartItem", cartService.getOne(id));
		System.out.println(cartService.totalPrice());
		System.out.println("id"+id+" quantity"+ quantity);
		return json;
	}
}
