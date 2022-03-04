package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domains.entities.Payment;

@RepositoryRestResource(exported = false)
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	<T> List<T> findByPaymentIdIsNotNull(Class<T> type);
	<T> Iterable<T> findByPaymentIdIsNotNull(Sort sort, Class<T> type);
	<T> Page<T> findByPaymentIdIsNotNull(Pageable pageable, Class<T> type);

}
