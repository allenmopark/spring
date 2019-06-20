package kr.re.kitri.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.re.kitri.hellospring.model.User;
import kr.re.kitri.hellospring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/greet")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}
	
	// 사용자 전체 보기 
	@GetMapping("/users")
	public List<User> getAllUsers(@RequestParam(value="page", defaultValue="0") int page) {
		System.out.println("page number=" + page);
		return userService.searchUsers();
	}
		
		// 사용자 상세 보기 
	@GetMapping("/users/{userId}")
	@ResponseBody
	public User getUsersById(@PathVariable Integer userId) {
		System.out.println(userId + ".. from path variable");
		return userService.searchUserByUserid(userId);
	}
	
	// 사용자 등록 
	@PostMapping("/users")
	@ResponseBody
	public User registUser(@RequestBody User user) {
		return userService.registUser(user);
	}
	
	
	
	// 사용자 수정 
	// 사용자 삭제 

	
	
}
