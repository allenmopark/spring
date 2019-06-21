package kr.re.kitri.hellospring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.re.kitri.hellospring.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {
	
	@Autowired
	private UserDao_spring_jdbc userDao;

	@Test
	public void testInsertUser() {
		User user = new User(500,"테스트임",1000);
	    User returned = userDao.insertUser(user);
	    // Assert.assertTrue(user.getUserid()==returned.getUserid());
	    Assert.assertNotNull(returned);
	    
	}

}
