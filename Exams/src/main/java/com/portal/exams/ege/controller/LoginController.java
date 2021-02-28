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
import com.portal.exams.ege.model.entity.LoginEntity;
import com.portal.exams.ege.service.LoginService;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	LoginService LoginService;
	
	@RequestMapping(value = "/v1/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseModel credit(
			@RequestBody(required = false) LoginEntity login) {
		return LoginService.login(login);

	}

}
