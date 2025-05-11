package com.glody.glodyAPI.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findByUser_UserId(Long userId);

	List<Payment> findByStatusAndTransactionDateBetween(Payment.PaymentStatus status, Date startDate, Date endDate);

	List<Payment> findByPartner_PartnerId(Long partnerId);
}