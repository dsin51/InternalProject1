package com.training.ifaces;

public interface DAOValidate<T> {

	public boolean validate(String user,String pwd, String role);
}
