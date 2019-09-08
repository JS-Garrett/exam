package org.hnjk.jaxb.model;

import java.io.Serializable;
import java.util.List;

public class Questions implements Serializable{
	List<Question> question;

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
}
