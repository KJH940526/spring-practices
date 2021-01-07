package com.bitacademy.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.bitacademy.aoptest.vo.ProductVo com.bitacademy.aoptest.service.ProductService.find(String))")
	public void beforeAdivce() {
		System.out.println("--- before Adivce... ---");
	}
				//퍼블릭 생략가능// 리턴타입을 *로 와일드카드 한거임!!
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdivce() {
		System.out.println("--- after Adivce... ---");
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdivce() {
		System.out.println("--- afterReturning Adivce... ---");
	}
	
	@AfterThrowing(value = "execution(* *..*.*.ProductService.*(..))", throwing = "ex")
	public void afterThrowingAdivce(Throwable ex) {
		System.out.println("--- afterThrowing Adivce : --- " + ex + " ---");
	}
	
	@Around("execution(* *..*.*.ProductService.*(..))")
	public Object aroundAdivce(ProceedingJoinPoint pjp) throws Throwable {
		// before advice	
		System.out.println("--- #Around(before) Adivce... ---");
		
		// PointCut Method 실행
		
		// 파라미터 가로채기!!
//		Object[] parmas = {"camera"};
//		Object result = pjp.proceed(parmas);
		
		Object result = pjp.proceed(); //예외처리를 해줌!
	
		
		// after advice	
		System.out.println("--- #Around(after) Adivce... ---");
		
		return result;
	}
	
}
