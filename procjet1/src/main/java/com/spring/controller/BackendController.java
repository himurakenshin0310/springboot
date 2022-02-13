package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.spring.entity.Product;
import com.spring.entity.Type;
import com.spring.entity.User;
import com.spring.model.ProductDto;
import com.spring.model.TypeDto;
import com.spring.model.UserDto;
import com.spring.repository.ProductRepository;
import com.spring.repository.TypeRepository;
import com.spring.security.CustomUserDetail;
import com.spring.service.ProductService;

@Controller
@RequestMapping("admin/")
public class BackendController {

	@Autowired
	ProductService productService;

	@Autowired
	TypeRepository typeRepo;

	@Autowired
	ProductRepository proRepo;

	@Autowired
	HttpSession session;

	@GetMapping("center")
	public String centerAdmin(@AuthenticationPrincipal CustomUserDetail user) {
		System.out.println(user.getUsername());
		return "backend/center";
	}

	@GetMapping("product")
	public String productCenter(Model model, @RequestParam(defaultValue = "0") int page) {
		if (page > 0)
			page -= 1;
		Page<Product> p = proRepo.findAll(PageRequest.of(page, 5, Sort.by("id").descending()));
		Map<String, Object> paginate = new HashMap<String, Object>();
		paginate.put("totalPage", p.getTotalPages());
		paginate.put("totalElements", p.getTotalElements());
		paginate.put("currentPage", p.getNumber() + 1);
		model.addAttribute("paginate", paginate);
		model.addAttribute("products", p);
		return "backend/product";
	}

	@GetMapping("add-product")
	public String getAddProd(Model model) {
		model.addAttribute("types", typeRepo.findAll());
		return "backend/addproduct";
	}

	@PostMapping("creating")
	public ModelAndView creating(@RequestParam MultipartFile file, @ModelAttribute ProductDto product)
			throws IllegalStateException, IOException {
		Product p = new Product();
		p.setDescription(product.getDescription());
		p.setEnable(true);
		p.setImage(file.getOriginalFilename());
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setType(typeRepo.findById(product.getTypeId()).get());
		proRepo.save(p);
		Files.write(Paths.get("src\\main\\resources\\static\\upload\\" + file.getOriginalFilename()), file.getBytes());
		return new ModelAndView("redirect:/admin/product");
	}

	@GetMapping("type")
	public String type(Model model) {
		model.addAttribute("types", typeRepo.findAll());
		return "backend/type";
	}

	@GetMapping("add-type")
	public String addType(Model model) {
		model.addAttribute("types", typeRepo.findAll().stream().map(TypeDto::create).collect(Collectors.toList()));
		return "backend/addtype";
	}

	@PostMapping("add-type")
	public ModelAndView createType(@RequestParam String name) {
		Type t = new Type();
		t.setName(name);
		t.setStatus(true);
		typeRepo.save(t);
		return new ModelAndView("redirect:/admin/type");
	}

	@GetMapping("product/change/{id}")
	public String changeProd(Model model, @PathVariable long id) {
		model.addAttribute("product", ProductDto.create(proRepo.findById(id).get()));
		model.addAttribute("types", typeRepo.findAll());
		return "backend/changeproduct";
	}

	@PostMapping("product/change/{id}")
	public ModelAndView postChangeProduct(MultipartFile file, ProductDto prodDto, @PathVariable long id)
			throws IOException {
		Product p = proRepo.findById(id).get();
		p.setDescription(prodDto.getDescription());
		p.setEnable(true);
		p.setName(prodDto.getName());
		p.setPrice(prodDto.getPrice());
		if (file.getBytes().length != 0) {
			p.setImage(file.getOriginalFilename());
			Files.write(Path.of("src\\main\\resources\\static\\upload\\" + file.getOriginalFilename()),
					file.getBytes());
		}
		proRepo.save(p);
		return new ModelAndView("redirect:/admin/product/change/" + id);
	}

	@GetMapping("product/enable/{id}")
	public ModelAndView changeEnableProduct(@PathVariable long id) {
		Product p = proRepo.findById(id).get();
		if (p.isEnable())
			p.setEnable(false);
		else
			p.setEnable(true);
		proRepo.save(p);
		return new ModelAndView("redirect:/admin/product");
	}

	@GetMapping("type/enable/{id}")
	public ModelAndView changeEnableType(@PathVariable long id) {
		Type t = typeRepo.findById(id).get();
		if (t.isStatus())
			t.setStatus(false);
		else
			t.setStatus(true);
		typeRepo.save(t);
		return new ModelAndView("redirect:/admin/type");
	}

	@GetMapping("type/change/{id}")
	public String changeType(Model model, @PathVariable long id) {
		model.addAttribute("type", TypeDto.create(typeRepo.findById(id).get()));
		return "backend/changetype";
	}

	@PostMapping("change-type/{id}")
	public ModelAndView postChangeType(@PathVariable long id, @RequestParam String name) {
		Type t = typeRepo.findById(id).get();
		t.setName(name);
		typeRepo.save(t);
		return new ModelAndView("redirect:/admin/type/");
	}
}
