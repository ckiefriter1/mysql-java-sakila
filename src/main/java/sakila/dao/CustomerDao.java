package sakila.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import sakila.entity.Customer;
import sakila.exception.DbException;


public class CustomerDao {

	private Connection conn = null;

	public CustomerDao() {
		this.conn = DbConnection.getConnection();
	}

	/*
	 * This method queries the customer table ands returns the results as a List of
	 * Customer objects.
	 */
	public List<Customer> getCustomerList() {
		
		List<Customer> custList = new ArrayList<Customer>();
	   
		String query = "select first_name,"
			   		 + "       last_name,"
			   		 + "       email "
			   		 + "  from customer"
			   		 + "  order by last_name, first_name; ";
			   
	    try {
	    	Statement stmt = this.conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    while (rs.next()) {
			    Customer cust = new Customer();
		    	cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				cust.setEmail(rs.getString("email"));
				custList.add(cust);
		    }
		    return custList;
		} catch (SQLException e) {
			throw new DbException(e);
		}	
	}

	public void printCustomerList() {
		   
		String query = "select first_name,"
			   		 + "       last_name,"
			   		 + "       email "
			   		 + "  from customer"
			   		 + "  order by last_name, first_name; ";
			   
	    try {
	    	Statement stmt = this.conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    while (rs.next()) {
			    String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				System.out.println("Customer Name: " + firstName + " " + lastName + " -> Email: " + email);
		    }
		} catch (SQLException e) {
			throw new DbException(e);
		}	
	}

}
