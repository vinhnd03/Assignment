package edu.poly.asm.controller.site;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.swing.Renderer;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.asm.domain.Account;
import edu.poly.asm.domain.CartItem;
import edu.poly.asm.domain.Category;
import edu.poly.asm.domain.Customer;
import edu.poly.asm.domain.Product;
import edu.poly.asm.model.AdminLoginDto;
import edu.poly.asm.model.CartItemDto;
import edu.poly.asm.model.CategoryDto;
import edu.poly.asm.model.ProductDto;
import edu.poly.asm.model.SiteRegisterDto;
import edu.poly.asm.service.AccountService;
import edu.poly.asm.service.CartItemService;
import edu.poly.asm.service.CategoryService;
import edu.poly.asm.service.CustomerService;
import edu.poly.asm.service.ProductService;
import edu.poly.asm.service.StorageService;

@Controller
@RequestMapping("site/products")
public class SiteProductController {
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
	AccountService accountService;
	
	@Autowired
	HttpSession session;
	
	@ModelAttribute("categories")
	public List<CategoryDto> getCatrgories() {
		return categoryService.findAll().stream().map(item -> {
			CategoryDto dto = new CategoryDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}

	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Product> list = productService.findAll();

		model.addAttribute("products", list);

		return "site/products/list";
	}

//	@GetMapping("addToCart/{productId}")
//	Public ModelAndView addToCart(ModelMap model, @PathVariable("productId") Long productId) {
//		return new ModelAndView("forward:/site/products", model);
//	}
	
	@GetMapping("detail/{productId}")
	public ModelAndView edit(ModelMap model, @PathVariable("productId") Long productId) {

		Optional<Product> opt = productService.findById(productId);
		ProductDto dto = new ProductDto();

		if (opt.isPresent()) {
			Product entity = opt.get();

			BeanUtils.copyProperties(entity, dto);

			dto.setCategoryId(entity.getCategory().getCategoryId());
			// dto.setIsEdit(true);

			model.addAttribute("product", dto);

			return new ModelAndView("site/products/detail", model);
		}

		model.addAttribute("message", "Product is not exist!");

		return new ModelAndView("forward:/site/products", model);
	}

	@GetMapping("addToCart/{productId}")
	public ModelAndView addToCart(ModelMap model, @PathVariable("productId") Long productId,
	        @ModelAttribute("product") ProductDto dto, BindingResult result,
	        HttpSession session) {

	    Optional<Product> opt = productService.findById(productId);

	    if (opt.isPresent()) {
	        CartItem entity = new CartItem();

	        String username = (String) session.getAttribute("username");
	        //Customer customer = customerService.findCustomerByUsername(username);

	        Optional<Account> account = accountService.findById(username);
	        
	        
	        Product product = opt.get();

	        //entity.setQuantity(dto.getQuantity());
	        entity.setProduct(product);
	        entity.setAccount(account.get());
	        entity.setQuantity(1);
	        
	        cartItemService.save(entity);

	        model.addAttribute("cartItem", entity);

	        return new ModelAndView("forward:/site/products/cart", model);
	    }

	    model.addAttribute("message", "Product does not exist!");

	    return new ModelAndView("forward:/site/products", model);
	}
	
	@GetMapping("cart")
	public String cart(ModelMap model) {
		String username = (String) session.getAttribute("username");
		
		//Customer customer = customerService.findCustomerByUsername(username);
				
		//int customerId = customer.getCustomerId();
		//System.out.println("cus: " + customerId);
		
		
		List<CartItem> list = cartItemService.findByAccount_Username(username);
		//List<CartItem> list = cartItemService.findByCustomer_CustomerId(customerId);
		
//		
		model.addAttribute("cartItem", list);

		return "site/products/cart";
	}
	
//	@GetMapping("addToCart/{productId}")
//	public ModelAndView addToCart(ModelMap model, @PathVariable("productId") Long productId,
//			@ModelAttribute("product") ProductDto dto,
//			BindingResult result) {
//
//		Optional<Product> opt = productService.findById(productId);
//		
//		if (opt.isPresent()) {
//			
//			CartItem entity = new CartItem();
//			
//			//BeanUtils.copyProperties(entity, dto);
//			
//			//int quantity = (int) model.getAttribute("quantity");
//			String username = (String) session.getAttribute("username");
//			System.out.println(username);
//			Customer customer = customerService.findCustomerByUsername(username);
//			
//			//customer.get().getCustomerId();
////			dto.setProductId(opt.get().getProductId());
////			System.out.println(opt.get().getProductId());
////			dto.setCustomerId(1);
////			dto.setQuantity(1);
////			dto.setCartItemId(1);
//			//BeanUtils.copyProperties(dto, entity);
//			
//			Product product = new Product();
//			product.setProductId(dto.getProductId());
//			
//			
//			
//			//customer.setCustomerId(customer.get().getCustomerId());
//			
//			//entity.setCartItemId(null);
//			//(dto.getCategoryId());
////			Customer customer = new Customer();
////			customer.setCustomerId(dto.getCustomerId());
//			
//			
//			entity.setQuantity(dto.getQuantity());
//			entity.setProduct(product);
//			//entity.setCustomer(customer);
//			
//			
//			System.out.println(entity.toString());
//					
//			cartItemService.save(entity);
//			
//			model.addAttribute("cartItem", dto);
//			
//			
//			return new ModelAndView("site/products/cart", model);
//		}
//
//		model.addAttribute("message", "Product is not exist!");
//
//		return new ModelAndView("forward:/site/products", model);
//	}
	
}
