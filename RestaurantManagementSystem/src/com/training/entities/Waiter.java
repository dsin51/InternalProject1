package com.training.entities;

import java.util.*;


public class Waiter extends Employee {

	private int waiterId;
	private ArrayList<Tables> tables;
	private int numberOfCustomers;
	private Hashtable<Integer, Integer> dishesOrdered;
	
	public Waiter() {
		super();
		dishesOrdered = new Hashtable<Integer, Integer>();
	}

	public Hashtable<Integer, Integer> addOrderItem(int dishId, int quantity)
	{
		dishesOrdered.put(dishId, quantity);
		return dishesOrdered;
	}

	public void placeOrder()
	{
		
	}
}
