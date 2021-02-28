package com.portal.exams.ege.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exams.ege.model.ResponseModel;
import com.portal.exams.ege.model.entity.ExamsEntity;
import com.portal.exams.ege.service.ExamsService;

@RestController
@CrossOrigin(origins = "*")
public class ExamController {

	@Autowired
	ExamsService examsService;

	@RequestMapping(value = "/v1/exams/save", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseModel save(
			@RequestBody(required = false) String exams,
			HttpServletRequest request) {

		return examsService.save(exams, request);

	}

	@RequestMapping(value = "/v1/exams/get/id/{exam_id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "*")
	public @ResponseBody ArrayList<ExamsEntity> get(
			@PathVariable("exam_id") String examID) {

		return examsService.get(examID);

	}

	@RequestMapping(value = "/v1/exams/get/date/{date}/user/{username}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@CrossOrigin(origins = "*")
	public @ResponseBody ArrayList<ExamsEntity> get(
			@PathVariable("date") Date date,
			@PathVariable("username") String userName) {

		return examsService.get(date,userName);

	}

}
