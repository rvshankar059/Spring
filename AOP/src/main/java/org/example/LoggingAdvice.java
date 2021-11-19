package org.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoggingAdvice implements LoggingAspect{
    @Override
    public void beforeAdvice() {


    }

    @Pointcut("execution(* org.example.Bank.*(int))")
    private void pointcutWithParameter(){}


    @Pointcut("execution(int org.example.Bank.*(..))")
    private void pointcutReturningValue(){}



    @After("pointcutWithParameter()")
    public void afterAdvice() {
        System.out.println("Transaction Completed");
    }

    @AfterReturning("pointcutReturningValue()")
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Balance now is "+retVal.toString());
    }

}
