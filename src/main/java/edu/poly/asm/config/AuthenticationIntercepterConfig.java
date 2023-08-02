package edu.poly.asm.config;

import java.rmi.registry.Registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.poly.asm.inteceptor.AdminAuthenticationInterceptor;
import edu.poly.asm.inteceptor.SiteAuthenticationInterceptor;

@Configuration
public class AuthenticationIntercepterConfig implements WebMvcConfigurer{
	@Autowired
	private AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	
	@Autowired
	private SiteAuthenticationInterceptor siteAuthenticationInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationInterceptor)
		.addPathPatterns("/admin/**");
		
//		registry.addInterceptor(siteAuthenticationInterceptor)
//		.addPathPatterns("/site/**");
	}
	
	
}
