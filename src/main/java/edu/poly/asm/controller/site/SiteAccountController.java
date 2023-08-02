package edu.poly.asm.controller.site;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.asm.domain.Account;
import edu.poly.asm.model.AdminLoginDto;
import edu.poly.asm.model.SiteRegisterDto;
import edu.poly.asm.service.CartItemService;
import edu.poly.asm.service.CategoryService;
import edu.poly.asm.service.CustomerService;
import edu.poly.asm.service.ProductService;
import edu.poly.asm.service.StorageService;

@Controller
@RequestMapping("site")
public class SiteAccountController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	StorageService storageService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CartItemService cartItemService;
	
	
	
	@Autowired
	HttpSession session;
	
	@GetMapping("register")
	public String register(ModelMap model) {
		model.addAttribute("account", new SiteRegisterDto());
		
		return "site/account/register";
	}
	
	@PostMapping("register")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("account") AdminLoginDto dto, 
			BindingResult result) {
		
//		if(result.hasErrors()) {
//			return new ModelAndView("/admin/accounts/login" , model);
//		}
//		
//		Account account = accountService.login(dto.getUsername() , dto.getPassword());
//		
//		if(account == null) {
//			model.addAttribute("message", "Invalid username or password");
//			return new ModelAndView("/admin/accounts/login" , model);
//		}
//		session.setAttribute("username", account.getUsername());
//		
//		Boolean isAdmin = account.getAdmin();
//		if(isAdmin == false) {
//			return new ModelAndView("forward:/site/products");
//		}
//		
//		
//		Object ruri = session.getAttribute("redirect-uri");
//		
//		if(ruri != null) {
//			session.removeAttribute("redirect-uri");
//			return new ModelAndView("redirect:" + ruri);
//		}
//		model.addAttribute("message" ,"Đăng nhập thành công");		
		
		return new ModelAndView("forward:/admin/products", model);
	}
}
