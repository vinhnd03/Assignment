package edu.poly.asm.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartitems")
public class CartItem implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CartItemId;
	
//	@Column(nullable = true)
//	private int productId;
//	
	////private String name;
	@Column(nullable = true)
	private int quantity;
	////private double unitPrice;
	//private int customerId;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
		
//	@OneToOne
//	@JoinColumn(name = "customerId")
//	private Customer customer;	
//	@OneToOne(mappedBy = "cartItem")
//	private Account account;
	
//	@OneToOne
//	@JoinColumn(name = "username")
//	private Account account;
	@ManyToOne
    @JoinColumn(name = "username")
    private Account account;
}
