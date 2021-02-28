package com.portal.exams.ege.model;

import java.util.HashMap;


public class AnswerWrapper {

	private String username;
	private HashMap<String, String> answers;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HashMap<String, String> getAnswers() {
		return answers;
	}

	public void setAnswers(HashMap<String, String> answers) {
		this.answers = answers;
	}

}
