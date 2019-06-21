package kr.re.kitri.hellospring.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.hellospring.service.SecurityService;

@RestController
public class AuthController {
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/generate/token")
	public Map<String, Object> generateTokenWithUserid(
									@RequestParam String userid){
		String token = securityService.generateToken(userid);
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		return map;
	}

}
