package com.portal.exams.ege.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.exams.ege.model.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, String> {
	@Query("SELECT t FROM LoginEntity t WHERE t.user_name = ?1 and t.password = ?2")
	LoginEntity findByUsername(String userName, String password);
}
