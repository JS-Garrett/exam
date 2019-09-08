package org.hnjk.exception;

import javax.servlet.http.HttpServletRequest;

import org.hnjk.properties.ExamProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)  {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getMessage());
		mav.setViewName(ExamProperties.DEFAULT_ERROR_VIEW);
		return mav;
	}
}
