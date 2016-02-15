package com.training.daos;

import java.sql.*;

import com.training.entities.Employee;
import com.training.ifaces.*;
import com.training.utils.SqlConnection;

public class EmployeeDAO implements DAO<Employee>, DAOValidate<Employee> {

	private Connection con;
	
	public EmployeeDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public EmployeeDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}




	@Override
	public int add(Employee t) {
		String sql = "insert into Employee values(?,?,?,?,?)";
		int rowAdded = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getEmpName());
			pstmt.setInt(2, t.getEmpId());
			pstmt.setString(3, t.getUserName());
			pstmt.setString(4, t.getEmpPwd());
			pstmt.setString(5, t.getEmpRole());
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public Employee view(int empId) {
		String sql = "select * from employee where id=?";
		Employee emp = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String pwd = rs.getString("password");
				String role = rs.getString("role");
				emp = new Employee(name, id, username, pwd, role);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int update(int empId, String pwd) {
		
		String sql = "update employee set password=? where id=?";
		int rowsUpdated = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setInt(2, empId);
			rowsUpdated = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return rowsUpdated;
	}

	@Override
	public boolean validate(String user, String pwd, String role) {
		String sql = "Select * from employee where username=? and password=? and role=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pwd);
			pstmt.setString(3, role);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
