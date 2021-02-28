package com.portal.exams.ege.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.portal.exams.ege.constant.Status;
import com.portal.exams.ege.dao.LoginRepository;
import com.portal.exams.ege.model.ResponseModel;
import com.portal.exams.ege.model.TransactionException;
import com.portal.exams.ege.model.entity.LoginEntity;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	private LoginEntity getUser(LoginEntity login) {
		LoginEntity loginEntity = loginRepository.findByUsername(
				login.getUser_name(), login.getPassword());
		Assert.notNull(loginEntity, "Username or Password Incorrect!");
		return loginEntity;
	}

	public ResponseModel login(LoginEntity login) {
		ResponseModel out = new ResponseModel();
		try {
			if (login == null)
				throw new TransactionException(
						"Check your username and password!");
			LoginEntity loginEntity = getUser(login);

			out.setStatus(Status.OK.name());
			out.setType(loginEntity.getPerson_type());

		} catch (Exception e) {
			out.setStatus(Status.FAIL.name());
			out.setError(e.getLocalizedMessage());
		}
		return out;

	}
}
