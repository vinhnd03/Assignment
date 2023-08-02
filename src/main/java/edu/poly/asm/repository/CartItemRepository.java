package edu.poly.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.asm.domain.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	//List<CartItem> findByCustomer_CustomerId(int customerId);
	List<CartItem> findByAccount_Username(String username);
}
