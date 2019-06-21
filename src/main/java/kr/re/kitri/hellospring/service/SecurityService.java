package kr.re.kitri.hellospring.service;

public interface SecurityService {
	String generateToken(String userid);
	
	boolean isValidToken(String token);

}
