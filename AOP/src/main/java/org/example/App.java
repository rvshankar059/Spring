package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx= new ClassPathXmlApplicationContext("aop.xml");
        Bank b = (Bank)ctx.getBean("bank");
        b.Deposit(1000);
        b.withdraw(3000);
        b.welcome();
        b.showBalance();

    }
}
