package com.training.ifaces;

public interface DAO<T> {
	
	public int add(T t);
	public T view(int empId);
	public int update(int empId, String pwd);
	
}
