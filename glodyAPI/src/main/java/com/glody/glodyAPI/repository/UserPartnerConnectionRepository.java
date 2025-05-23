package com.glody.glodyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glody.glodyAPI.model.UserPartnerConnection;

@Repository
public interface UserPartnerConnectionRepository extends JpaRepository<UserPartnerConnection, Long> {
	List<UserPartnerConnection> findByUser_UserId(Long userId);

	List<UserPartnerConnection> findByPartner_PartnerId(Long partnerId);

	List<UserPartnerConnection> findByStatus(UserPartnerConnection.ConnectionStatus status);
}