package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Product;
import com.spring.model.ProductDto;
import com.spring.repository.ProductRepository;
import com.spring.repository.TypeRepository;
import com.spring.repository.UserRepository;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	TypeRepository typeRepo;

	@GetMapping("/")
	public String home(Model model) {
		Page<Product> p = productRepo.findAll(PageRequest.of(0, 5, Sort.by("id").descending()));
		Map<String, Object> paginate = new HashMap<String, Object>();
		paginate.put("totalPage", p.getTotalPages());
		paginate.put("totalElements", p.getTotalElements());
		paginate.put("currentPage", p.getNumber() + 1);
		model.addAttribute("paginate", paginate);
		model.addAttribute("products", p);
		return "frontend/index";
	}

	@GetMapping("detail/{id}")
	public String products(Model model, @PathVariable long id) {
		model.addAttribute("product", productRepo.findById(id).get());
		return "frontend/detailproduct";
	}

	@GetMapping("products")
	public String products(Model model, @RequestParam(defaultValue = "0") int page) {
		if (page > 0)
			page -= 1;
		Page<Product> p = productRepo.findAll(PageRequest.of(page, 5, Sort.by("id").descending()));
		model.addAttribute("products", p);
		Map<String, Object> paginate = new HashMap<String, Object>();
		paginate.put("totalPage", p.getTotalPages());
		paginate.put("totalElements", p.getTotalElements());
		paginate.put("currentPage", p.getNumber() + 1);
		model.addAttribute("paginate", paginate);
		return "frontend/products";
	}

	@GetMapping("search")
	public String searching(Model model, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String key, @RequestParam(defaultValue = "1") int type) {
		if (page > 0)
			page -= 1;
		Page<Product> p = productRepo.searchByNameAndType(type, key, PageRequest.of(page, 5));
		model.addAttribute("products", p.getContent());
		model.addAttribute("types", typeRepo.findAll());
		return "frontend/search";
	}

	@PostMapping("search")
	public String postSearching(Model model, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "") String key, @RequestParam(defaultValue = "1") int type) {
		if (page > 0)
			page -= 1;
		Page<Product> p = productRepo.searchByNameAndType(type, key, PageRequest.of(page, 5));
		model.addAttribute("products", p.getContent());
		model.addAttribute("types", typeRepo.findAll());
		model.addAttribute("key", key);
		model.addAttribute("type", type);
		model.addAttribute("result", p.getTotalElements());
		return "frontend/search";
	}

	@GetMapping("pagesearch")
	@ResponseBody
	public List<ProductDto> loadMore(@RequestParam int page, String key, int type) {
		return productRepo.searchByNameAndType(type, key, PageRequest.of(page, 5)).getContent().stream()
				.map(ProductDto::create).collect(Collectors.toList());
	}
}
