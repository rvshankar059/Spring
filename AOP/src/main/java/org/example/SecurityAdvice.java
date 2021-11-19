package org.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;

@Aspect
public class SecurityAdvice implements SecurityAspect{

    @Pointcut("execution(* org.example.Bank.*(..))")
    private void secure()
    {

    }

    @Before("secure()")
    public void beforeAdvice() {
        System.out.println("Security check Completed");
    }

    @Override
    public void afterAdvice() {

    }
}
