package sakila;

import java.util.Iterator;
import java.util.List;

import sakila.dao.*;
import sakila.entity.Customer;

public class Sakila {

	public static void main(String[] args) {
		
		CustomerDao dao = new CustomerDao();
		
		System.out.println("----------------------------------------------------");
		System.out.println("************       Customer List       *************");
		System.out.println("----------------------------------------------------");
		//dao.printCustomerList();
		
		List<Customer> custList = dao.getCustomerList();
		Iterator<Customer> listIterator = custList.iterator();
		while (listIterator.hasNext()) {
			Customer cust = listIterator.next();
			System.out.println("Customer Name: " + cust.getFirstName() + " " + cust.getLastName() + " -> Email: " + cust.getEmail());
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("Total # of Customers: " + custList.size());
		System.out.println("----------------------------------------------------");
		

	}

}
