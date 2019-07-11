package spring.backendSpring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AOPTest {

	
//	@Before("execution(* spring.CompactDisc.play())")
	public void abc() {
		System.out.println("abc");
	}
	
//	@After("execution(* spring.CompactDisc.play())")
	public void bcd() {
		System.out.println("123");
	}
	
	@Around("execution(* spring.backendSpring.CompactDisc.play())")
	public void cde(ProceedingJoinPoint jp)  {
		try {
			
			System.out.println("Around before");
			jp.proceed();
			System.out.println("Around after");
		}catch(Throwable e) {
		}
	}
}
