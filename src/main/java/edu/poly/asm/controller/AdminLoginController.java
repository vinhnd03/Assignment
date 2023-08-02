package edu.poly.asm.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.asm.domain.Account;
import edu.poly.asm.model.AdminLoginDto;
import edu.poly.asm.service.AccountService;

@Controller
public class AdminLoginController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("alogin")
	public String login(ModelMap model) {
		model.addAttribute("account", new AdminLoginDto());
		return "/admin/accounts/login";
	}
	
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("account") AdminLoginDto dto, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("/admin/accounts/login" , model);
		}
		
		Account account = accountService.login(dto.getUsername() , dto.getPassword());
		
		if(account == null) {
			model.addAttribute("message", "Invalid username or password");
			return new ModelAndView("/admin/accounts/login" , model);
		}
		session.setAttribute("username", account.getUsername());
		System.out.println(session.getAttribute("username"));
		
		Boolean isAdmin = account.getAdmin();
		if(isAdmin == false) {
			return new ModelAndView("forward:/site/products");
		}
		
		
		Object ruri = session.getAttribute("redirect-uri");
		
		if(ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		model.addAttribute("message" ,"Đăng nhập thành công");		
		
		return new ModelAndView("forward:/admin/products", model);
	}
	
	@GetMapping("alogout")	
	public ModelAndView logout(ModelMap model) {
		session.setAttribute("username", null);
		model.addAttribute("message" ,"Đăng xuất thành công");
		
		return new ModelAndView("forward:/alogin", model);
	}
	
	
}
