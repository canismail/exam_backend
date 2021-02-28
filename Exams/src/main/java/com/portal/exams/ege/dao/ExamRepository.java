package com.portal.exams.ege.dao;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.exams.ege.model.entity.ExamsEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamsEntity, String> {

	@Query("SELECT t FROM ExamsEntity t WHERE t.exam_id = ?1")
	ArrayList<ExamsEntity> findByExamId(String examId);

	@Query("SELECT t FROM ExamsEntity t WHERE ?1 between t.start_date and t.end_date and not exists (select 1 from AnswerEntity a where a.exam_id = t.exam_id and a.user_name = ?2)")
	ArrayList<ExamsEntity> findByDate(Date date, String userName);

}
