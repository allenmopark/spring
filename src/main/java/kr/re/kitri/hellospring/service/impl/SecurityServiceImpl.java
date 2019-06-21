package kr.re.kitri.hellospring.service.impl;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.re.kitri.hellospring.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	private String privateKey = "wlierhflsnfsd98u32or5lksnfd";
	
	@Override
	public String generateToken(String userid) {
		
		SignatureAlgorithm sa = SignatureAlgorithm.HS256;
		byte[] apiKeyByte = DatatypeConverter.parseBase64Binary(privateKey);
		Key signingKey = new SecretKeySpec(apiKeyByte, sa.getJcaName());
		JwtBuilder builder = Jwts.builder()
				.setSubject(userid)
				.signWith(sa, signingKey);
		
		return builder.compact();
		
	}
	
	@Override
	public boolean isValidToken(String token) {
		Jwts.parser()
			.setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
			.parseClaimsJws(token);
		return true;
	}
	

}
