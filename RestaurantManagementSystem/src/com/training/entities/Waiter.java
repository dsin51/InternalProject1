package com.training.entities;

import java.util.*;

import com.training.daos.OrderDAO;
import com.training.utils.SqlConnection;


public class Waiter extends Employee {


	private ArrayList<Integer> tables;
	private int numberOfCustomers;

	public Waiter() {
		super();
	}
	public Waiter(String empName, int empId, String userName, String empPwd, String empRole,
			ArrayList<Integer> tables, int numberOfCustomers) {
		super(empName, empId, userName, empPwd, empRole);

		this.tables = tables;
		this.numberOfCustomers = numberOfCustomers;
	}
		
	public ArrayList<Integer> getTables() {
		return tables;
	}
	public void setTables(ArrayList<Integer> tables) {
		this.tables = tables;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	public Hashtable<Integer, Integer> getDishesOrdered() {
		return dishesOrdered;
	}
	public void setDishesOrdered(Hashtable<Integer, Integer> dishesOrdered) {
		this.dishesOrdered = dishesOrdered;
	}



	private Hashtable<Integer, Integer> dishesOrdered;
	
	public Hashtable<Integer, Integer> addOrderItem(int dishId, int quantity)
	{
		dishesOrdered.put(dishId, quantity);
		return dishesOrdered;
	}

	/*
	 * creates and returns map of (dishId, quantity) 
	 * 
	 */
	public Hashtable<Integer, Integer> buildOrder(int items, int itemlist[], int itemQuantity[])
	{
		int item = items;
		int list[] = itemlist;
		int quantList[] = itemQuantity;
		Hashtable<Integer, Integer> dishesOrdered = new Hashtable<Integer, Integer>();
		for(int i = 0; i < item; i++ )
		{
			dishesOrdered.put(list[i], quantList[i]);
		}
		
		return dishesOrdered;
	}
	/*
	 * creates Orders object (Not needed)-> used parameterized constructor in Orders class
	 */
//	public Orders createOrder(int orderNo, int tableNo, int waiterId, Hashtable<Integer, Integer> dishes,
//			String status, int numberOfCustomers)
//	{
//		Orders newOrder = new Orders(orderNo, tableNo, waiterId, dishes, status, numberOfCustomers);
//		return newOrder;
//	}
	/*
	 * takes the Orders object and adds it to the database
	 */
	public void placeOrder(Orders newOrder)
	{
		OrderDAO dao = new OrderDAO();
		dao.add(newOrder);
	}
}
