package edu.poly.asm.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.asm.domain.CartItem;

public interface CartItemService {

	

	//List<CartItem> findByCustomer_CustomerId(int customerId);

	<S extends CartItem> List<S> findAll(Example<S> example, Sort sort);

	<S extends CartItem> List<S> findAll(Example<S> example);

	void deleteAll();

	CartItem getReferenceById(Long id);

	void deleteAll(Iterable<? extends CartItem> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	CartItem getById(Long id);

	void delete(CartItem entity);

	CartItem getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends CartItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends CartItem> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<CartItem> entities);

	<S extends CartItem> long count(Example<S> example);

	boolean existsById(Long id);

	void deleteInBatch(Iterable<CartItem> entities);

	Optional<CartItem> findById(Long id);

	<S extends CartItem> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends CartItem> S saveAndFlush(S entity);

	void flush();

	<S extends CartItem> List<S> saveAll(Iterable<S> entities);

	List<CartItem> findAllById(Iterable<Long> ids);

	List<CartItem> findAll(Sort sort);

	Page<CartItem> findAll(Pageable pageable);

	List<CartItem> findAll();

	<S extends CartItem> Optional<S> findOne(Example<S> example);

	<S extends CartItem> S save(S entity);

	List<CartItem> findByAccount_Username(String username);

}
