package org.hnjk.exception;

import javax.servlet.http.HttpServletRequest;

import org.hnjk.entity.Result;
import org.hnjk.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest req, Exception e)  {
		return ResultUtil.error("invalid-parameter", "参数填写不正确");
	}
}
