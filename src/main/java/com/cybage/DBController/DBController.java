package com.cybage.DBController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cybage.*;
import com.cybage.model.Product;
import com.cybage.utility.JDBCUtility;
public class DBController {
	
	

	public boolean insertProduct(Product product) {
		boolean result=false;
		try {
			String sql="insert into product values(?,?,?)";
			Connection connection = JDBCUtility.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, product.getPid());
			stmt.setString(2, product.getPname());
			stmt.setDouble(3, product.getPprice());
			
			int inserted = stmt.executeUpdate();
			result = inserted >=1;
			
			JDBCUtility.disconnect(connection);
		} catch (Exception e) {

			e.printStackTrace();		}
		return result;
	}

	public boolean deleteProduct(int id) {
		boolean result=false;
		try {
			String sql="delete from product where Pid=?;";
			Connection connection = JDBCUtility.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			int delete=stmt.executeUpdate();
			result= delete>=1;
			
			JDBCUtility.disconnect(connection);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return result;

}
	
	public boolean updateProduct(Product product) {
		boolean result=false;
		try {
			String sql="update product set pi=?,pname=?,pprice=? where pid=?";
			Connection connection = JDBCUtility.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, product.getPid());
			stmt.setString(2, product.getPname());
			stmt.setDouble(3, product.getPprice());
			
			int updated=stmt.executeUpdate();
			result=updated>=1;
			
			
			JDBCUtility.disconnect(connection);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return result;
}
	
	public Product getProduct(int id) {
		Product product = null;
		try {
			String sql="select * from product where product id=?";
			
			Connection connection = JDBCUtility.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()) {
				product = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				
			}
			JDBCUtility.disconnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return product;
		
	}
	
	public ArrayList<Product> getProducts(){
		ArrayList<Product> products=new ArrayList<Product>();
		Product product = null;
		try {
			String sql="select * from product";
			
			Connection connection = JDBCUtility.getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery();
			
			while (rs.next()) {
				product = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
					products.add(product);
			}
			
			JDBCUtility.disconnect(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return products;
		
	}
}
