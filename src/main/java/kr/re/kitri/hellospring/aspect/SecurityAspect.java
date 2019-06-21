package kr.re.kitri.hellospring.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import io.jsonwebtoken.Jwts;
import kr.re.kitri.hellospring.annotation.TokenRequired;

@Aspect
@Component
public class SecurityAspect {
	
	private String privateKey = "wlierhflsnfsd98u32or5lksnfd";
	
	@Before("@annotation(tokenRequired)")
	public void authenticateWithToken(TokenRequired tokenRequired) {
		
		ServletRequestAttributes sra = 
				(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		
		HttpServletRequest request = sra.getRequest();
		String token = request.getHeader("token");
		
		Jwts.parser()
		.setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
		.parseClaimsJws(token);
	}

}
