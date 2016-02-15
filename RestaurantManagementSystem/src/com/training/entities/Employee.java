package com.training.entities;

public class Employee {

	private String empName;
	private int empId;
	private String userName;
	private String empPwd;
	private String empRole;
	public Employee(String empName, int empId, String userName, String empPwd, String empRole) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.userName = userName;
		this.empPwd = empPwd;
		this.empRole = empRole;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", userName=" + userName + ", empPwd=" + empPwd
				+ ", empRole=" + empRole + "]";
	}
	
}
