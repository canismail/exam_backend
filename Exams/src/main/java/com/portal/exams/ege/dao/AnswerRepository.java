package com.portal.exams.ege.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.exams.ege.model.entity.AnswerEntity;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, String> {

	@Query("SELECT t FROM AnswerEntity t WHERE t.answer_id = ?1")
	ArrayList<AnswerEntity> findByAnswerId(String examId);

}
