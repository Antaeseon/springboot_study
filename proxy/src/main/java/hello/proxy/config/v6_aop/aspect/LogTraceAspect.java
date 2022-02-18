package hello.proxy.config.v6_aop.aspect;

import hello.proxy.trace.logtrace.LogTrace;

public class LogTraceAspect {
    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }


}
