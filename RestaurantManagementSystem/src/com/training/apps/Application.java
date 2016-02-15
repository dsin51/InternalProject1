package com.training.apps;

import com.training.daos.EmployeeDAO;
import com.training.entities.Employee;

public class Application {
	
	public static void main(String args[]) {
//		Employee e1 = new Employee("Ramesh",102,"ramesh101","pwd","waiter");
//		EmployeeDAO dao = new EmployeeDAO();
//		int rowAdded =  dao.add(e1);
//		System.out.println(rowAdded+" row[s] added.");
		
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.view(102));
		
		System.out.println("~~~~Validation Check~~~~~");
		boolean check = dao.validate("ramesh101", "pwd", "waiter");
		if(check)
		{
			System.out.println("validated");
		}
		else System.out.println("Invalid Credentials");
		
		
		
		System.out.println("~~~~~~~~Updating Password~~~~~~~~");
		int rowsUpdated = dao.update(102, "pwd123");
		System.out.println(rowsUpdated+" row[s] updated");
		System.out.println(dao.view(102));
	}
}
