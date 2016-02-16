package com.training.entities;

import java.util.*;

import com.training.daos.OrderDAO;

public class Chef extends Employee {

	
	public Chef() {
		super();
	}

	public void printPendingOrderNumbers()
	{
		OrderDAO dao = new OrderDAO();
		ArrayList<Integer> pendingOrders = dao.getPendingOrders();
		if(pendingOrders==null)
		{
			System.out.println("No Pending Orders");
		}
		System.out.println("List of pending Orders:");
		for (Iterator iterator = pendingOrders.iterator(); iterator.hasNext();) 
		{
			Integer orderNumber = (Integer) iterator.next();
			System.out.println(orderNumber);
			
		}
	}
	
	public void printOrders(int i)
	{
		OrderDAO dao = new OrderDAO();
		Orders order = dao.view(i);
		int orderNumber = order.getOrderNo();
		int tableNumber = order.getTableNo();
		int waiterId = order.getWaiterId();
		Hashtable<Integer, Integer> orderedItems = order.getDishes();
		String status = order.getStatus();
		int numberOfCustomers = order.getNumberOfCustomers();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("------------------------------------");
		System.out.println("Order Number:"+orderNumber);
		System.out.println("Status:"+status);
		System.out.println("Table Number:"+tableNumber);
		System.out.println("Waiter Id:"+waiterId);
		System.out.println("Number of Customers:"+numberOfCustomers);
		System.out.println("------------------------------------");
		System.out.println("Item"+"\tQuantity");
		System.out.println("------------------------------------");
		Set<Map.Entry<Integer, Integer>> list = orderedItems.entrySet();
		for(Map.Entry<Integer, Integer> dishId : list)
		{
			System.out.println(dishId.getKey()+"\t"+dishId.getValue());
		}
		System.out.println("------------------------------------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
}
