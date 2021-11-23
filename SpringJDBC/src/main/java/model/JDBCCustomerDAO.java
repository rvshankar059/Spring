package model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCustomerDAO implements CustomerDAO {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Customer customer) {
        String sql = "insert into Customer values(?,?,?)";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, customer.getCust_id());
            pst.setString(2, customer.getName());
            pst.setInt(3, customer.getAge());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }


    }

    @Override
    public Customer findCustomerByIf(int custid) {
        String sql = "select * from Customer where cust_id=?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, custid);
            ResultSet rs = pst.executeQuery();
            Customer c = null;
            while (rs.next()) {
                c = new Customer();
                c.setCust_id(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAge(rs.getInt(3));
            }
//           else
//           {
//               System.out.println("No such record exists");
//               return null;
//           }
            if (c != null) return c;
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Customer> findAllCustomer(int custid) {
        ArrayList<Customer> cs = new ArrayList<Customer>();

        String sql = "select * from Customer where cust_id=?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, custid);
            ResultSet rs = pst.executeQuery();
            Customer c = null;
            while (rs.next()) {
                c = new Customer();
                c.setCust_id(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAge(rs.getInt(3));
                cs.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cs;
    }
}
