package com.training.daos;

import java.sql.*;
import java.util.*;
import com.training.entities.Dishes;
import com.training.entities.Orders;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;

public class OrderDAO implements DAO<Orders>{

	private Connection con;

	public OrderDAO(Connection con) {
		super();
		this.con = con;
	}
	public OrderDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}
	@Override
	public int add(Orders t) {
		String sql = "insert into orders values(?,?,?)";
		int rowAddedOrders = 0;
		int orderNumber = t.getOrderNo();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getOrderNo());
			pstmt.setInt(2, t.getTableNo());
			pstmt.setInt(3, t.getWaiterId());
			
			rowAddedOrders = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		/*
		 * 
		 * Orders class sends (key,value) pair of (dihsId, quantity)
		 * Retrieve each dish and store them into the database
		 */
		Hashtable<Integer, Integer> dishList = t.getDishes();
		Set<Map.Entry<Integer, Integer>> list = dishList.entrySet();
		String sql2 = "insert into ordereditems values(?,?,?)";
		for(Map.Entry<Integer, Integer> dishId : list)
		{
			try {
				PreparedStatement pstmt = con.prepareStatement(sql2);
				pstmt.setInt(1, dishId.getKey()); //dishId
				pstmt.setInt(2, orderNumber); //Order number is same for this set of dish items ordered
				pstmt.setInt(3, dishId.getValue()); //quantity
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return rowAddedOrders;
		
	}
	@Override
	public Orders view(int key) {
		String sql = "select * from Orders join ordereditems on orders.ordernumber=ordereditems.ordernumber "
				+ "where orders.ordernumber="+key;
		Orders order = null;
		int orderNumber = 0;
		int tableNumber =0;
		int waiterId = 0;
		int dishId = 0;
		int quantity = 0;
		Hashtable<Integer, Integer> orderedItems = new Hashtable<Integer, Integer>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				orderNumber = rs.getInt("ordernumber");
				tableNumber = rs.getInt("tablenumber");
				waiterId = rs.getInt("waiterid");
				dishId = rs.getInt("dishid");
				quantity = rs.getInt("quantity");
				orderedItems.put(dishId, quantity);
			}
			order = new Orders(orderNumber, tableNumber, waiterId, orderedItems, "not-prepared", 4);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return order;
		
	}
	@Override
	public int update(int key, String value) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<Integer> getPendingOrders()
	{
		String sql = "Select * from orders where status='pending'";
		ArrayList<Integer> pendingOrders = new ArrayList<Integer>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				pendingOrders.add(rs.getInt("ordernumber"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return pendingOrders;
	}
}
