package edu.poly.asm.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.asm.domain.CartItem;
import edu.poly.asm.repository.CartItemRepository;
import edu.poly.asm.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	CartItemRepository cartItemRespository;

//	@Override
//	public List<CartItem> findByCustomer_CustomerId(int customerId){
//		return cartItemRespository.findByCustomer_CustomerId(customerId);
//	}


	@Override
	public List<CartItem> findByAccount_Username(String username){
		return cartItemRespository.findByAccount_Username(username);
	}
	
	@Override
	public <S extends CartItem> S save(S entity) {
		return cartItemRespository.save(entity);
	}

	@Override
	public <S extends CartItem> Optional<S> findOne(Example<S> example) {
		return cartItemRespository.findOne(example);
	}

	@Override
	public List<CartItem> findAll() {
		return cartItemRespository.findAll();
	}

	@Override
	public Page<CartItem> findAll(Pageable pageable) {
		return cartItemRespository.findAll(pageable);
	}

	@Override
	public List<CartItem> findAll(Sort sort) {
		return cartItemRespository.findAll(sort);
	}

	@Override
	public List<CartItem> findAllById(Iterable<Long> ids) {
		return cartItemRespository.findAllById(ids);
	}

	@Override
	public <S extends CartItem> List<S> saveAll(Iterable<S> entities) {
		return cartItemRespository.saveAll(entities);
	}

	@Override
	public void flush() {
		cartItemRespository.flush();
	}

	@Override
	public <S extends CartItem> S saveAndFlush(S entity) {
		return cartItemRespository.saveAndFlush(entity);
	}

	@Override
	public <S extends CartItem> List<S> saveAllAndFlush(Iterable<S> entities) {
		return cartItemRespository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CartItem> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartItemRespository.findAll(example, pageable);
	}

	@Override
	public Optional<CartItem> findById(Long id) {
		return cartItemRespository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<CartItem> entities) {
		cartItemRespository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return cartItemRespository.existsById(id);
	}

	@Override
	public <S extends CartItem> long count(Example<S> example) {
		return cartItemRespository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CartItem> entities) {
		cartItemRespository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends CartItem> boolean exists(Example<S> example) {
		return cartItemRespository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		cartItemRespository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends CartItem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cartItemRespository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return cartItemRespository.count();
	}

	@Override
	public void deleteAllInBatch() {
		cartItemRespository.deleteAllInBatch();
	}

	@Override
	public void deleteById(Long id) {
		cartItemRespository.deleteById(id);
	}

	@Override
	public CartItem getOne(Long id) {
		return cartItemRespository.getOne(id);
	}

	@Override
	public void delete(CartItem entity) {
		cartItemRespository.delete(entity);
	}

	@Override
	public CartItem getById(Long id) {
		return cartItemRespository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		cartItemRespository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends CartItem> entities) {
		cartItemRespository.deleteAll(entities);
	}

	@Override
	public CartItem getReferenceById(Long id) {
		return cartItemRespository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		cartItemRespository.deleteAll();
	}

	@Override
	public <S extends CartItem> List<S> findAll(Example<S> example) {
		return cartItemRespository.findAll(example);
	}

	@Override
	public <S extends CartItem> List<S> findAll(Example<S> example, Sort sort) {
		return cartItemRespository.findAll(example, sort);
	}
	
	
	
}
