package kr.re.kitri.hellospring.service;

import java.util.List;

import kr.re.kitri.hellospring.model.User;

public interface UserService {
	
	User searchUserByUserid(Integer userId);
	List<User> searchUsers();
	User registUser(User user);
	List<User> searchUserByUsername(String username);
	

}
