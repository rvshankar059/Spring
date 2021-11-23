package org.example;

import model.Customer;
import model.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CustomerDAO dao = (CustomerDAO)ctx.getBean("customerDAO");
        Customer c = new Customer();
        c.setName("sultan");
        c.setCust_id(301);;
        c.setAge(30);
        dao.insert(c);

        System.out.println("record inserted"); //

        Customer f=dao.findCustomerByIf(302);
        System.out.println(f.getName());
        System.out.println(f.getCust_id());

        List<Customer> cs = dao.findAllCustomer(302);
        cs.forEach((v)->{System.out.print(v.getName());});



















    }
}
