package com.portal.exams.ege.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(ExamsCompositeKey.class)
@Table(name = "EXAMS")
public class ExamsEntity {

	@Id
	private String exam_id;
	@Column
	private Date start_date;
	@Column
	private Date end_date;
	@Id
	private String question;
	@Column
	private String choice_1;
	@Column
	private String choice_2;
	@Column
	private String choice_3;
	@Column
	private String choice_4;
	@Column
	private String exams_link;

	public ExamsEntity() {
	}

	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	public String getExams_link() {
		return exams_link;
	}

	public void setExams_link(String exams_link) {
		this.exams_link = exams_link;
	}

}
