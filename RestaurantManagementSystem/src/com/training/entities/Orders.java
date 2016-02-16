package com.training.entities;

import java.util.ArrayList;
import java.util.Hashtable;

public class Orders {

	private int orderNo;
	private int tableNo;
	private int waiterId;
	private Hashtable<Integer, Integer> dishes;
	private String status;
	private int numberOfCustomers;
	public Orders(int orderNo, int tableNo, int waiterId, Hashtable<Integer, Integer> dishes, String status,
			int numberOfCustomers) {
		super();
		this.orderNo = orderNo;
		this.tableNo = tableNo;
		this.waiterId = waiterId;
		this.dishes = dishes;
		this.status = status;
		this.numberOfCustomers = numberOfCustomers;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public int getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}
	public Hashtable<Integer, Integer> getDishes() {
		return dishes;
	}
	public void setDishes(Hashtable<Integer, Integer> dishes) {
		this.dishes = dishes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", tableNo=" + tableNo + ", waiterId=" + waiterId + ", dishes=" + dishes
				+ ", status=" + status + ", numberOfCustomers=" + numberOfCustomers + "]";
	}
	
}
