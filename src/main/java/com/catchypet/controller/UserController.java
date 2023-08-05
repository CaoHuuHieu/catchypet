package com.catchypet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.catchypet.model.entity.BookingEntity;
import com.catchypet.model.entity.ContactEntity;
import com.catchypet.service.BookingService;
import com.catchypet.service.CategoryService;
import com.catchypet.service.ContactService;
import com.catchypet.service.ProductService;
import com.catchypet.service.ServiceService;
import com.catchypet.service.StoreInforService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private BookingService bookinhService;
	@Autowired
	private StoreInforService storeInforService;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ContactService contactService;
//	@Autowired
//	private NewService newService;
	@GetMapping(value = {"/", "home"})
	public String homepage(Model model) {
		model.addAttribute("categories", categoryService.getCategoryForProduct());
		model.addAttribute("products", productService.getProductsOnSale());
		model.addAttribute("featuredProducts", productService.getFeaturesProducts());
		model.addAttribute("accessoryies", productService.getAccessories());
//		model.addAttribute("news", newService.getNew().subList(0.2));
		return "user/home";
	}
	
	@GetMapping(value = {"/service"})
	public String servicePage(Model model) {
		model.addAttribute("services", serviceService.getAllService());
		return "user/service";
	}
	
	
	
	@GetMapping(value = {"/booking"})
	public String bookingPage(Model model) {
		model.addAttribute("booking", new BookingEntity());
		return "user/booking";
	}
	
	@PostMapping(value = {"/booking"})
	public String addBooking(@ModelAttribute BookingEntity booking) {
		try {
			bookinhService.save(booking);
			session.setAttribute("message", new Message("Đặt lịch thành công!", "success"));
		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xãy ra!", "error"));
		}
		return "redirect:/booking";
	}
	
	
	@GetMapping(value = {"/new"})
	public String newPage(Model model) {
		return "user/new";
	}
	@GetMapping(value = {"/contact"})
	public String contactPage(Model model) {
		model.addAttribute("storeInfor", storeInforService.getStoreInfor());
		model.addAttribute("contact", new ContactEntity());
		return "user/contact";
	}
	
	
	@PostMapping(value = {"/contact"})
	public String addContact(@ModelAttribute ContactEntity contact) {
		try {
			contactService.save(contact);
			session.setAttribute("message", new Message("Đã gửi thành công!", "success"));
		}catch(Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Đã có lỗi xãy ra!", "error"));
		}
		return "redirect:/contact";
	}
}
