package com.portal.exams.ege.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exams.ege.model.ResponseModel;
import com.portal.exams.ege.service.AnswerService;

@RestController
@CrossOrigin(origins = "*")
public class AnswerController {

	@Autowired
	AnswerService answerService;

	@RequestMapping(value = "/v1/answer/save", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseModel save(
			@RequestBody(required = false) String answerWrapper) {

		return answerService.save(answerWrapper);

	}

}
