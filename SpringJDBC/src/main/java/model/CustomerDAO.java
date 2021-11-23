package model;

import java.util.List;

public interface CustomerDAO {
    public void insert(Customer custmer);
    public Customer findCustomerByIf(int custid);
    public List<Customer> findAllCustomer(int custid);
}
