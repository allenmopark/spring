package kr.re.kitri.hellospring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.hellospring.dao.UserDao;
import kr.re.kitri.hellospring.dao.UserDao_spring_jdbc;
import kr.re.kitri.hellospring.model.User;
import kr.re.kitri.hellospring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User searchUserByUserid(Integer userId) {
		return userDao.selectUserByKey(userId);
	}
	
	@Override
	public List<User> searchUsers(){
		return userDao.selectAllUsers();
	}

	@Override
	public User registUser(User user) {
		return userDao.insertUser(user);
	}
	
	@Override
	public List<User> searchUserByUsername(String username){
		return userDao.selectUserByUsername(username);
	}

}
