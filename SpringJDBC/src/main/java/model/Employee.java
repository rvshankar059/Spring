package model;

import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {
    Connection conn;
    Employee()
    {
        conn = DriverManager.getConnection()
    }
    @Before
    @After
    public void insertEmp()
    {


    }
    @Before
    public void deleteEmp()
    {

    }
    Before
    public void updateEmp()
    {

    }
    public void fetchEmp()
    {

    }
}
