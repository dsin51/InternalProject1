package com.training.ifaces;

public interface DAO<T> {
	
	public int add(T t);
	public T view(int key);
	public int update(int key, String value);
	
}
