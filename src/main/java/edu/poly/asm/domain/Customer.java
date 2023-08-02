package edu.poly.asm.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String name;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
//	@Column(length = 30, nullable = false)
//	private String username;
	@Column(length = 30, nullable = false)
	private String password;
	@Column(length = 20)
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	@Column(nullable = true)
	private short status;	
//	@Column(length = 30, nullable = false, unique = true)
//	private String username;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;
		
//	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//	private Set<CartItem> cartItems;
//	@OneToOne
//	@JoinColumn(name = "cart_item_id")
//	private CartItem cartItem;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
//	@OneToOne(mappedBy = "customer")
//	private Account account;
}
