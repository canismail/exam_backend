package com.portal.exams.ege.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.exams.ege.constant.Status;
import com.portal.exams.ege.dao.ExamRepository;
import com.portal.exams.ege.model.ExamsWrapper;
import com.portal.exams.ege.model.ResponseModel;
import com.portal.exams.ege.model.entity.ExamsEntity;

@Service
public class ExamsService {

	@Autowired
	ExamRepository examRepository;

	public String getExamId() {
		return java.util.UUID.randomUUID().toString();
	}

	public ResponseModel save(String examsList, HttpServletRequest request) {
		ResponseModel response = new ResponseModel();
		try {
			String examID = getExamId();
			//URL url = new URL(request.getRequestURL().toString());
			JSONArray jsonArray = new JSONArray(examsList);
			for (int i = 0; i < jsonArray.length(); i++) {

				ExamsWrapper wrapper = new ObjectMapper().readValue(jsonArray
						.get(i).toString(), ExamsWrapper.class);

				ExamsEntity exam = new ExamsEntity();

				exam.setQuestion(wrapper.getQuestion());
				exam.setChoice_1(wrapper.getAnswerA());
				exam.setChoice_2(wrapper.getAnswerB());
				exam.setChoice_3(wrapper.getAnswerC());
				exam.setChoice_4(wrapper.getAnswerD());

				SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
				
				Calendar c = Calendar.getInstance(); 
				c.setTime(df.parse(wrapper.getStartDate().substring(0,10))); 
				c.add(Calendar.DATE, 1);
				exam.setStart_date(c.getTime());
				
				c.setTime(df.parse(wrapper.getEndDate().substring(0,10))); 
				c.add(Calendar.DATE, 1);
				exam.setEnd_date(c.getTime());
				
				exam.setExam_id(examID);
				examRepository.save(exam);

			}

			response.setStatus(Status.OK.name());

		} catch (Exception e) {
			response.setStatus(Status.FAIL.name());
			response.setError(e.getLocalizedMessage());
		}

		return response;
	}

	public ArrayList<ExamsEntity> get(String examID) {
		return examRepository.findByExamId(examID);
	}

	public ArrayList<ExamsEntity> get(Date date,String userName) {
		return examRepository.findByDate(date,userName);
	}
}
