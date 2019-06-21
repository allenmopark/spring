package kr.re.kitri.hellospring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RuntimeEstimaitonAspect {
	
	@Around("execution(* kr.re.kitri.hellospring.dao.*.*(..))")
	public Object estimateRuntime(ProceedingJoinPoint pjp) throws Throwable {
		// .. 메소드 호출 직전에 실행되는 코드 ..
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		// .. 메소드 실행 후 실행되는 코드 
		long estimatedTime = System.currentTimeMillis() - start;
		System.out.println(
				pjp.getSignature().getName() 
				+ "메소드 실행 시간 : " + estimatedTime);
		return obj;
		
	}

}
