package com.example.domains.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.PaymentRepository;
import com.example.domains.contracts.repositories.RentalRepository;
import com.example.domains.contracts.services.PaymentService;
import com.example.domains.contracts.services.RentalService;
import com.example.domains.entities.Payment;
import com.example.domains.entities.Rental;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {
	private PaymentRepository dao;
	
	public PaymentServiceImpl(PaymentRepository dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Payment> getAll() {
		return dao.findAll();
	}
	
	@Override
	public Iterable<Payment> getAll(Sort sort) {
		return dao.findAll(sort);
	}
	@Override
	public Page<Payment> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}
	
	@Override
	public <T> List<T> getByProjection(Class<T> type) {
		return dao.findByPaymentIdIsNotNull(type);
	}

	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		return dao.findByPaymentIdIsNotNull(sort, type);
	}

	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		return dao.findByPaymentIdIsNotNull(pageable, type);
	}

	@Override
	public Payment getOne(Integer id) throws NotFoundException {
		var item = dao.findById(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get();
	}
	
	@Override
	public Payment add(Payment item) throws DuplicateKeyException, InvalidDataException {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getPaymentId()).isPresent())
			throw new DuplicateKeyException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	@Override
	public Payment change(Payment item) throws NotFoundException, InvalidDataException  {
		if(item == null)
			throw new IllegalArgumentException();
		if(dao.findById(item.getPaymentId()).isEmpty())
			throw new NotFoundException();
		if(item.isInvalid())
			throw new InvalidDataException(item.getErrorsMessage());
		return dao.save(item);
	}
	@Override
	public void delete(Payment item) {
		if(item == null)
			throw new IllegalArgumentException();
		deleteById(item.getPaymentId());
		
	}
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
