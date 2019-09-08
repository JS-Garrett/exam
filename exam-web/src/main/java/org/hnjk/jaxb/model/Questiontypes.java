package org.hnjk.jaxb.model;

import java.io.Serializable;
import java.util.List;
/**
 * 试卷题型
 * @author zxh
 *
 */
public class Questiontypes implements Serializable {
	
	
	List<Questiontype> questiontype;

	public List<Questiontype> getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(List<Questiontype> questiontype) {
		this.questiontype = questiontype;
	}
	
	
	
	
}
