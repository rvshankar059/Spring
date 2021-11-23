package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer = new Customer();
        customer.setCust_id(resultSet.getInt(1));
        customer.setName(resultSet.getString(2));
        customer.setAge(resultSet.getInt(3));
        return customer;
    }
}
