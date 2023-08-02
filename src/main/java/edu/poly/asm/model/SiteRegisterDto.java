package edu.poly.asm.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteRegisterDto{
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String Email;
	
}