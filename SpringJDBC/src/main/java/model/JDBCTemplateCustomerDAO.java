package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JDBCTemplateCustomerDAO implements CustomerDAO {
    private JdbcTemplate jdbctemplate;
    private DataSource dataSource;

//    public JDBCTemplateCustomerDAO()
//    {
//        jdbctemplate = new JdbcTemplate(dataSource);
//    }


    public JdbcTemplate getJdbctemplate() {
        return jdbctemplate;
    }

    @Autowired
    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Customer custmer) {
        if(jdbctemplate==null)
        jdbctemplate = new JdbcTemplate(dataSource);
        jdbctemplate.execute("insert into customer values("+custmer.getCust_id()+",'"+custmer.getName()+"',"+custmer.getAge()+")");
    }

    @Override
    public Customer findCustomerByIf(int custid) {
        List<Customer> customers=jdbctemplate.query("select * from customer where cust_id="+custid+"",new CustomerMapper());

       return customers.get(0);
    }

    @Override
    public List<Customer> findAllCustomer(int custid) {
        List<Customer> customers=jdbctemplate.query("select * from customer where cust_id="+custid+"",new CustomerMapper());
        return customers;
    }

}
