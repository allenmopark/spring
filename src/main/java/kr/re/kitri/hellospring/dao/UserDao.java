package kr.re.kitri.hellospring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.re.kitri.hellospring.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public User insertUser(User user) {
		int updated = sqlSession.update(
				"kr.re.kitri.hellospring.dao.UserDao.insertUser", 
				user);
		return user;
	}
	
	public User selectUserByKey(Integer userId) {
		User user = sqlSession.selectOne(
				"kr.re.kitri.hellospring.dao.UserDao.selectUserByKey", userId);
		return user;
	}
	
	public List<User> selectAllUsers(){
		List<User> listOfUser = sqlSession.selectList(
				"kr.re.kitri.hellospring.dao.UserDao.selectAllUsers");
		return listOfUser;
	}

	public List<User> selectUserByUsername(String username) {
		return sqlSession.selectList(
				"kr.re.kitri.hellospring.dao.UserDao.selectUserByUsername", 
				username);
	}

}
