package com.training.apps;

import java.util.ArrayList;
import java.util.Hashtable;

import com.training.daos.EmployeeDAO;
import com.training.entities.Employee;
import com.training.entities.Orders;
import com.training.entities.Tables;
import com.training.entities.Waiter;

public class Application {
	
	public static void main(String args[]) {
//		Employee e1 = new Employee("Ramesh",102,"ramesh101","pwd","waiter");
//		EmployeeDAO dao = new EmployeeDAO();
//		int rowAdded =  dao.add(e1);
//		System.out.println(rowAdded+" row[s] added.");
		
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.view(102));
		
		System.out.println("~~~~Validation Check~~~~~");
		boolean check = dao.validate("ramesh101", "pwd123", "waiter");
		if(check)
		{
			System.out.println("validated");
		}
		else System.out.println("Invalid Credentials");
		
		
		
		System.out.println("~~~~~~~~Updating Password~~~~~~~~");
		int rowsUpdated = dao.update(102, "pwd123");
		System.out.println(rowsUpdated+" row[s] updated");
		System.out.println(dao.view(102));
		
		
		/*
		 * just for testing
		 * To do: create multiple Tables objects and assign them to waiters
		 */
		
		ArrayList<Integer> tables = new ArrayList<Integer>();
		tables.add(1);
		tables.add(2);
		tables.add(3);
		tables.add(4);
		tables.add(5);
		
		ArrayList<Integer> tableGroup1 = new ArrayList<Integer>();
		
		
		
		Waiter w1 = new Waiter("Ramesh", 101, "ramesh101", "pwd", "waiter",tableGroup1, 4);
		int itemlist[] = {11001,11003,11004};
		int itemQuantity[] = {2,2,2};
		Hashtable<Integer, Integer> orderedItems = w1.buildOrder(3, itemlist, itemQuantity);
		Orders newOrder = new Orders(2001, 2, 101, orderedItems, "preparing", w1.getNumberOfCustomers());
		w1.placeOrder(newOrder);
		
		
	}
}
