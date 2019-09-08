package org.hnjk.util;

import org.hnjk.entity.Result;

public class ResultUtil {
	public static Result success(Object object) {
        Result result = new Result();
        result.setCode("00");
        result.setMsg("成功");
        result.setObject(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
