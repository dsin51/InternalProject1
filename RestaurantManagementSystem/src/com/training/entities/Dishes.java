package com.training.entities;

public class Dishes {

	private int dishId;
	private String dishName;
	private int dishAvailabilty;
	private int dishPrice;
	public Dishes(int dishId, String dishName, int dishAvailabilty, int dishPrice) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishAvailabilty = dishAvailabilty;
		this.dishPrice = dishPrice;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getDishAvailabilty() {
		return dishAvailabilty;
	}
	public void setDishAvailabilty(int dishAvailabilty) {
		this.dishAvailabilty = dishAvailabilty;
	}
	public int getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}
	@Override
	public String toString() {
		return "Dishes [dishId=" + dishId + ", dishName=" + dishName + ", dishAvailabilty=" + dishAvailabilty
				+ ", dishPrice=" + dishPrice + "]";
	}
	
}
