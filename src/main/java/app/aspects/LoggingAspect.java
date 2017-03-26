package app.aspects;

import app.aspects.annotations.Loggable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Andrei Safronov
 */
@Component
@Aspect
public class LoggingAspect {

  @Value("${aspects.logging.enable}")
  private boolean enabled;

  @Around(value = "@annotation(app.aspects.annotations.Loggable)")
  public Object logServiceAccess(ProceedingJoinPoint joinPoint) throws Throwable {
    if (!enabled)
      return joinPoint.proceed();

    long start = System.currentTimeMillis();
    try {
      return joinPoint.proceed();
    } finally {
      Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
      String methodName = joinPoint.getSignature().getName();

      Loggable loggable = getAnnotation(joinPoint, Loggable.class);
      if (loggable.logCallDuration()) {
        long timeTakenMs = System.currentTimeMillis() - start;
        log.info("Executed {}() in {} ms", methodName, timeTakenMs);
      } else {
        log.info("Executed {}()", methodName);
      }
    }
  }

  private static <T extends Annotation> T getAnnotation(ProceedingJoinPoint joinPoint, Class<T> clazz) {
    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
    return method.getAnnotation(clazz);
  }
}
