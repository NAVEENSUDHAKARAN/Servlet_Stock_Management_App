package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.chainsys.model.*;
import com.chainsys.util.ConnectUtil;

public class ServerManager {

	Scanner scan = new Scanner(System.in);

	public void addProduct(StockInfo pojo) throws ClassNotFoundException, SQLException {

		while (true) {
			try {
				ConnectUtil connect = new ConnectUtil();
				Connection connection = ConnectUtil.getConnection();

				String query = "insert into Add_Stock_Details values (?,?,?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(query);

				prepareStatement.setInt(1, pojo.getId());
				prepareStatement.setString(2, pojo.getProductName());
				prepareStatement.setInt(3, pojo.getNumberOfStock());
				prepareStatement.setString(4, pojo.getStockedDate());
				prepareStatement.setDouble(5, pojo.getCostPrice());
				prepareStatement.setInt(6, 0);
				prepareStatement.setInt(7, 0);

				int rows = prepareStatement.executeUpdate();

				System.out.println("Rows Affected : " + rows);
				System.out.println("Inserted To DB!!!");
				break;
			} catch (SQLIntegrityConstraintViolationException e) {
				System.err.println(e);
				System.out.println("Enter ID Again : ");
				int id = scan.nextInt();
				pojo.setId(id);
				scan.nextLine();
			}
		}
	}

	public boolean retrieveUserCred(StockInfo pojo) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = connect.getConnection();
		
		String query = "Select UserName, PassWord from user_cred";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		ResultSet rows = prepareStatement.executeQuery();
		
		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				if(rows.getString(i).equals(pojo.getAdminName())){
					return false;
				}
			}
		}
		return true;
	}
	
	public void insertUserCred(StockInfo pojo) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "insert into user_cred values(?,?)";

		PreparedStatement prepareStatement = connection.prepareStatement(query);

		prepareStatement.setString(1, pojo.getAdminName());
		prepareStatement.setInt(2, pojo.getPassword());

		int rows = prepareStatement.executeUpdate();
		System.out.println("Rows Affected : " + rows);
		System.out.println("SignedIn Successfully!!!");
	}

	public boolean readUserCred(String UserName, int passWord) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select * from user_cred where UserName = ? and PassWord = ?";
		PreparedStatement prep = connection.prepareStatement(query);

		prep.setString(1, UserName);
		prep.setInt(2, passWord);
		ResultSet rows = prep.executeQuery();
		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return true;
			}
			System.out.println();
		}
		return false;

	}

	public static boolean validRead(String name) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "Select ID,Product_Name,Number_of_Stock,Stocked_Date ,Price from Add_Stock_Details where Product_Name = ?";
		PreparedStatement prep = connection.prepareStatement(query);

		prep.setString(1, name);
		ResultSet rows = prep.executeQuery();
		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return true;
			}
			System.out.println();
		}
		return false;
	}

	public static void read(int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select ID,Product_Name,Number_of_Stock,Stocked_Date ,Price from Add_Stock_Details where ID = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);

		prepareStatement.setInt(1, id);

		ResultSet rows = prepareStatement.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i += 1) {
			System.out.print(metaData.getColumnName(i) + " \t ");
		}
		System.out.println();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				System.out.print(rows.getString(i) + "\t\t");
			}
			System.out.println();
		}
	}

	public static void readStock(int id1, int id2) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select ID,Product_Name,Number_of_Stock,Stocked_Date ,Price from Add_Stock_Details where ID >= ? and ID < ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);

		prepareStatement.setInt(1, id1);
		prepareStatement.setInt(2, id2);

		ResultSet rows = prepareStatement.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i += 1) {
			System.out.print(metaData.getColumnName(i) + " \t ");
		}
		System.out.println();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				System.out.print(rows.getString(i) + "\t\t");
			}
			System.out.println();
		}
	}

	public static int retrieveStock(String str) throws SQLException, ClassNotFoundException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select Number_of_Stock from Add_Stock_Details where Product_Name = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);

		prepareStatement.setString(1, str);

		ResultSet rows = prepareStatement.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return rows.getInt(i);
			}
			System.out.println();
		}
		return 0;
	}

	public static int retrieveStockUsingId(int id) throws SQLException, ClassNotFoundException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select Number_of_Stock from Add_Stock_Details where ID = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);

		prepareStatement.setInt(1, id);
		ResultSet rows = prepareStatement.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return rows.getInt(i);
			}
			System.out.println();
		}
		return 0;
	}

	public static void updateDb(int updatedStock, String name) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "update Add_Stock_Details set Number_of_Stock = ? where Product_Name = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, updatedStock);
		prepareStatement.setString(2, name);

		int rows = prepareStatement.executeUpdate();
		System.out.println("Rows Affected : " + rows);

	}

	public static void delete(String name) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "delete from Add_Stock_Details where Product_Name = ?";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, name);

		int rows = prepareStatement.executeUpdate();
		System.out.println("Rows Affected : " + rows);

	}

	public static Queue displayStock(int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();
		Queue<String> queue = new LinkedList<>();

		String query = "select ID, Product_Name, Price from Add_Stock_Details where ID = ?";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, id);

		ResultSet rows = prepareStatement.executeQuery();
		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				queue.add(rows.getString(i));
			}
			System.out.println();
		}

		return queue;

	}

	public static int amountCalculate(int id) throws SQLException, ClassNotFoundException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select Price from Add_Stock_Details where ID = ?";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, id);

		ResultSet rows = prepareStatement.executeQuery();
		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return rows.getInt(i);
			}
			System.out.println();
		}
		return 0;

	}

	public static void updateStock(int updatedStock, int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "update Add_Stock_Details set Number_of_Stock = ? where ID = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, updatedStock);
		prepareStatement.setInt(2, id);

		int rows = prepareStatement.executeUpdate();

	}

	public static int retrieveSoldStock(int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = connect.getConnection();
		
		String query = "Select Stock_Purchased from Add_Stock_Details where ID = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, id);
		ResultSet rows = prepareStatement.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				return rows.getInt(i);
			}
			System.out.println();
		}
		return 0;
	}
	
	public static void inspectStock() throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "select ID,Product_Name,Number_of_Stock,Customer_Order ,Price from Add_Stock_Details where Number_of_Stock <= 10";

		PreparedStatement prep = connection.prepareStatement(query);

		ResultSet rows = prep.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		for (int i = 1; i <= columnCount; i += 1) {
			System.out.print(metaData.getColumnName(i) + " \t ");
		}
		System.out.println();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				System.err.print(rows.getString(i) + "\t\t");
			}
			System.out.println();
		}

	}

	public static void updateOrder(int order, int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();

		String query = "update Add_Stock_Details set Customer_Order = ? where ID = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, order);
		prepareStatement.setInt(2, id);

		int rows = prepareStatement.executeUpdate();
	}

	public static void updateStockCount(int purchaseCount, int id) throws ClassNotFoundException, SQLException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = ConnectUtil.getConnection();
		
		int updatedStock = purchaseCount + retrieveSoldStock(id);
		
		String query = "update Add_Stock_Details set Stock_Purchased = ? where ID = ?";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, updatedStock);
		prepareStatement.setInt(2, id);

		int rows = prepareStatement.executeUpdate();
		System.out.println("Affected Rows : " + rows);
	}

	public static void resetSoldStock() throws SQLException, ClassNotFoundException {
		ConnectUtil connect = new ConnectUtil();
		Connection connection = connect.getConnection();
		
		String query = "update Add_Stock_Details set Stock_Purchased = 0";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		int rows = prepareStatement.executeUpdate();
		System.out.println("Rows Affected : " + rows);
	}
	
	public static void highDemandStock() throws ClassNotFoundException, SQLException {

		ConnectUtil connect = new ConnectUtil();
		Connection connection = connect.getConnection();

		String query = "select ID, Product_Name, Price, stock_purchased from Add_Stock_Details where Stock_Purchased != 0 and Stock_Purchased is not null order by Stock_Purchased desc";

		PreparedStatement prep = connection.prepareStatement(query);

		ResultSet rows = prep.executeQuery();

		ResultSetMetaData metaData = rows.getMetaData();
		int columnCount = metaData.getColumnCount();

		for (int i = 1; i <= columnCount; i += 1) {
			System.out.print(metaData.getColumnName(i) + " \t\t ");
		}
		System.out.println();

		while (rows.next()) {
			for (int i = 1; i <= columnCount; i += 1) {
				System.out.print(rows.getString(i) + "\t\t\t");
			}
			System.out.println();
		}

	}

}