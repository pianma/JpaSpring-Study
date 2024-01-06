package JpaSpring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeTraceApp {

    @Around("execution(* JpaSpring..*(..))") //패키지명, 클래스명, 파라메터 타입 등등 원하는 조건을 넣을 수 있음. 현재 JpaSpring 패키지 하위는 전부 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        log.info("start : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.info("end : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
