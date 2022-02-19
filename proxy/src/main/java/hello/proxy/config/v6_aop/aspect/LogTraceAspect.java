package hello.proxy.config.v6_aop.aspect;

import hello.proxy.trace.logtrace.LogTrace;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogTraceAspect {
    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        return null;
    }

}
