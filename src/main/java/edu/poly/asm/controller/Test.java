package edu.poly.asm.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.poly.asm.domain.CartItem;
import edu.poly.asm.domain.Customer;
import edu.poly.asm.service.CartItemService;
import edu.poly.asm.service.CategoryService;
import edu.poly.asm.service.CustomerService;
import edu.poly.asm.service.ProductService;
import edu.poly.asm.service.StorageService;

public class Test {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	StorageService storageService;

	
	
	@Autowired
	static
	CartItemService cartItemService;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	static
	CustomerService customerService;
	

	//static List<CartItem> list = cartItemService.findByCustomer_CustomerId(1);
	
	static String username = "user12";
	
	public static Customer customer = customerService.findCustomerByUsername(username);
	
	
	public static void main(String[] args) {
		
		//System.out.println(customer);
		
		
		System.out.println(customer);
	}
}
