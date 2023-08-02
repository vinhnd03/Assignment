package edu.poly.asm.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto implements Serializable{
	private Long cartItemId;
	private Long productId;
	
	@NotEmpty
	@Min(1)
	private int quantity;
	
	private int customerId;
}
