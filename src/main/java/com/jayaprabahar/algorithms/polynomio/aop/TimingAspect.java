/**
 * 
 */
package com.jayaprabahar.algorithms.polynomio.aop;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : polynomio </p>
 * <p> Title : TimingAspect.java </p>
 * <p> Description: AOp implemented for time taken </p>
 * <p> Created: Nov 7, 2020 </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 *
 */
@Component
@Aspect
@Slf4j
public class TimingAspect {

	/**
	 * Performs AOP logics at controller level, means convers full application time taken
	 *  
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.jayaprabahar.algorithms.polynomio.controller..*(..))")
	public Object profileExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		LocalDateTime startTime = LocalDateTime.now();

		Object result = joinPoint.proceed();

		log.info("Time taken for the calculation {}", startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));

		return result;
	}

}
