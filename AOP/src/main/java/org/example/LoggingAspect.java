package org.example;

public interface LoggingAspect {
public void beforeAdvice();
public void afterAdvice();
public void afterReturningAdvice(Object retVal);

}
