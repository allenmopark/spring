package kr.re.kitri.hellospring.exception;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jsonwebtoken.SignatureException;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=BizException.class)
	@ResponseBody
	public Map<String, Object> handleBizException(SQLException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("error", true);
		map.put("msg",e.getMessage());
		map.put("error_code",120);
		return map;
	}
	
	@ExceptionHandler(value=SQLException.class)
	@ResponseBody
	public String handleSQLException(SQLException e) {
		Map<String, Object> map = new HashMap<>();
		map.put("error", true);
		map.put("msg",e.getMessage());
		map.put("error_code",120);
		return e.getMessage() + " SQL EXception 발생";
	}
	
	/*
	 * {
	 * 		"error": true,
	 * 		"msg": "You have an error in your SQL syntax",
	 * 		"error_code": 120
	 * }
	 * */
	
	@ExceptionHandler(value=NumberFormatException.class)
	@ResponseBody
	public String handleNumberFormatException(NumberFormatException e) {
		return e.getMessage();
	}

	@ExceptionHandler(value=SignatureException.class)
	@ResponseBody
	public Map<String, Object> handleSignatureException() {
		Map<String, Object> map = new HashMap<>();
		map.put("error", "인증 실패");
		return map;
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String handleException(Exception e) {
		return e.getMessage();
	}	
	
}


