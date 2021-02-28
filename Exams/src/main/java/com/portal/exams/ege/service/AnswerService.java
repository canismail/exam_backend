package com.portal.exams.ege.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portal.exams.ege.constant.Status;
import com.portal.exams.ege.dao.AnswerRepository;
import com.portal.exams.ege.model.ResponseModel;
import com.portal.exams.ege.model.entity.AnswerEntity;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	public String getAnswerId() {
		return java.util.UUID.randomUUID().toString();
	}

	public ResponseModel save(String answerWrapper) {
		ResponseModel response = new ResponseModel();

		try {
			String answerID = getAnswerId(); 

			if (answerWrapper == null || "".equals(answerWrapper))
				throw new NullPointerException("Kaydedilecek Data Bulunamadı");

			@SuppressWarnings("unchecked")
			Map<String, String> map = new ObjectMapper().readValue(
					answerWrapper, Map.class);
			String username = getValueFromMap(map, "username");
			String examid = getValueFromMap(map, "quiz_name");
			map.remove("username");
			map.remove("quiz_name");
			for (Entry<String, String> entry : map.entrySet()) {

				if ("STARTER".equals(examid)
						|| entry.toString().contains("Are You Ready?")) {
					continue;
				}

				AnswerEntity answer = new AnswerEntity();

				answer.setQuestion(entry.getKey());
				answer.setAnswer(entry.getValue());
				answer.setAnswer_id(answerID);
				answer.setUser_name(username);
				answer.setExam_id(examid);
				answerRepository.save(answer);
			}

			response.setStatus(Status.OK.name());

		} catch (Exception e) {
			response.setStatus(Status.FAIL.name());
			response.setError(e.getLocalizedMessage());
		}

		return response;
	}

	public String getValueFromMap(Map<String, String> map, String value) {
		for (Entry<String, String> entry : map.entrySet()) {
			if (value.equals(entry.getKey()))
				return entry.getValue();
		}
		return "";
	}

}
