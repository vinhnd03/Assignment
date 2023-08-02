package edu.poly.asm.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "accounts")
public class Account implements Serializable{
	@Id
	@Column(length = 30)
	private String username;
	
	@Column(length = 65, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Boolean admin;
	
//	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//	private Set<Customer> customers;
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private Customer customer;
	
//	@OneToOne
//	@JoinColumn(name = "username")
//	private Customer customer;
	
//	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//	private CartItem cartItem;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;
	
}
