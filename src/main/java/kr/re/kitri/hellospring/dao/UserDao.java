package kr.re.kitri.hellospring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.re.kitri.hellospring.model.User;

@Repository
public class UserDao {
	
	public User selectUserByKey(Integer userId) {
		
		// 데이터를 확보.. from anywhere..
		
		User user = new User(userId, "김순곤", 40);
		return user;
	}
	
	public List<User> selectAllUsers(){
		List<User> listOfUser = new ArrayList<>();
		listOfUser.add(new User(1, "김순곤", 40));
		listOfUser.add(new User(2, "yoon", 40));
		listOfUser.add(new User(3, "kwon", 40));
		listOfUser.add(new User(4, "choi", 40));
		listOfUser.add(new User(5, "lee", 40));
		listOfUser.add(new User(6, "kim", 40));
		return listOfUser;
	}

}
