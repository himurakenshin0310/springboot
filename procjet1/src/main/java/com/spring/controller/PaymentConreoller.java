package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Order;
import com.spring.entity.OrderDetail;
import com.spring.entity.Product;
import com.spring.entity.User;
import com.spring.model.UserDto;
import com.spring.repository.OrderDetailRepository;
import com.spring.repository.UserRepository;
import com.spring.security.RegistrationUser;
import com.spring.security.CustomUserDetail;
import com.spring.service.CartService;

@Controller
public class PaymentConreoller {
	@Autowired
	JavaMailSender javaMail;

	@Autowired
	RegistrationUser registraionUser;

	@Autowired
	CartService cartService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	com.spring.repository.Order orderRepo;

	@Autowired
	OrderDetailRepository orderDetailRepo;

	@GetMapping("sendmail")
	public void sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("kikyo0310@gmail.com");
		msg.setSubject("testing send mail using spring boot application!");
		msg.setText("succsess!");

		javaMail.send(msg);
	}

	@GetMapping("payment")
	public String getPayment() {

		return "frontend/payment";
	}

	@PostMapping("/paying")
	@ResponseBody
	public String postPayement(@AuthenticationPrincipal CustomUserDetail user) {
		if (cartService.totalPrice() != 0) {
			Order order = new Order();
			order.setTotalPrice(cartService.totalPrice());
			order.setUserOrder(userRepo.findById(user.idUser()).get());
			orderRepo.save(order);
			for (Product i : cartService.listProduct()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrder(order);
				orderDetail.setProducts(i);
				orderDetailRepo.save(orderDetail);
			}
			return "ok";
		}else
			return null;
	}

	@GetMapping("/registraion")
	public String getRegistraion() {
		return "frontend/registration";
	}

	@PostMapping("/registration")
	public ModelAndView resgistration(@RequestParam String email, String password) {
		System.out.println(email + password);
		UserDto u = new UserDto();
		u.setEmail(email);
		u.setEnable(true);
		u.setName("User1");
		u.setPassword(password);
		u.setPhone("0911651561");
		registraionUser.regsignUser(u);
		return new ModelAndView("redirect:/login");
	}

}
