package ltd.colingting.infrastructure.datahelper.exception;

import javax.validation.ConstraintViolationException;
import ltd.colingting.infrastructure.datahelper.vo.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月15日 11:16
 */
@Aspect
@Component
public class ResultAspect {
    @Around("@annotation(ltd.colingting.infrastructure.datahelper.exception.ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (ConstraintViolationException cve) {
            return Result.fail(cve.getMessage());
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return proceed;
    }
}
