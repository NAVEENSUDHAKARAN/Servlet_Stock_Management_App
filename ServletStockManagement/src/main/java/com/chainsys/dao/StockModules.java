package com.chainsys.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.chainsys.dao.*;
import com.chainsys.model.StockInfo;
import com.chainsys.dao.*;

public class StockModules {

	Scanner stockMethods = new Scanner(System.in);
	StringBuilder strBuilder = new StringBuilder();
	StockInfo pojo = new StockInfo();
	ServerManager db = new ServerManager();
	ValidationChecker check = new ValidationChecker();

	public void lowStock() {
		System.out.println("Your Stock Quantity is Below 10 Consider Buying !!!");
	}

	public int update(String name) {
		int addStock = 0;
		System.out.println("Do You Want to Update The " + name + " Stock (Y or N) : ");
		String yn = stockMethods.next();
		if (yn.toLowerCase().equals("y")) {
			System.out.println("Enter The Amount of Stocks to Add : ");
			addStock = stockMethods.nextInt();

		}
		return addStock;
	}

	public void delete(String path) {

		try {
			FileWriter writer = new FileWriter(path);

			writer.write("");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void write(String p) {
		Scanner scanner = new Scanner(System.in);
		try {

			System.out.println("Enter the ID : ");
			int id = scanner.nextInt();
			System.out.println("Enter the Product Name : ");
			String productName = scanner.next();
			FileWriter writer = new FileWriter(p, true);

			String str = id + " " + productName + " ";
			writer.write(str);

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void detailsWrite(String p) {
		Scanner scanner = new Scanner(System.in);
		try {

			System.out.println("Enter the ID : ");
			int id = scanner.nextInt();
			System.out.println("Enter the Product Name : ");
			String productName = scanner.next();
			System.out.println("Enter the Number of Stock : ");
			int numberOfStock = scanner.nextInt();
			System.out.println("Enter the Stocked Date : ");
			String stockedDate = scanner.next();
			System.out.println("Enter the Price of " + productName + " : ");
			int price = scanner.nextInt();

			FileWriter writer = new FileWriter(p, true);

			String str = id + " " + productName + " " + numberOfStock + " " + stockedDate + " " + price + "\n";
			writer.write(str);

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(String path) {
		try {
			FileReader reader = new FileReader(path);
			StringBuilder strBuilder = new StringBuilder();
			int num;
			char ch;
			while ((num = reader.read()) != -1) {
				ch = (char) num;
				strBuilder.append(ch);
			}
			String[] str = strBuilder.toString().split(" ");
			for (int i = 0; i < str.length; i += 1) {
				System.out.println(str[i] + " ---> " + str[i + 1]);
				i += 1;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean userDetailsRead(String userName, String password) {
		try {
			FileReader reader = new FileReader("D:\\UserDetails.txt");

			Scanner scanner = new Scanner(reader);
			String[] credentials = { userName, password };

			while (scanner.hasNextLine()) {
				String r = scanner.nextLine();
				String[] strArr = r.split(" ");
				if (strArr[0].equals(userName) && strArr[1].equals(password)) {
					return true;
				}
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public String retrieveStockName(String path, String name) {
		try {
			FileReader reader = new FileReader(path);
			Scanner scan = new Scanner(System.in);
			Scanner scanner = new Scanner(reader);

			while (scanner.hasNextLine()) {

				String str = scanner.nextLine();
				String[] strArr = str.split(" ");

				if (strArr[1].equals(name)) {
					return strArr[1];
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "empty";
	}

	public void sqlDetailsWrite() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the ID : ");
		int id = check.numberValidation();
		pojo.setId(id);
		System.out.println("Enter the Product Name : ");
		String productName = scanner.nextLine();
		while (!check.str(productName)) {
			System.err.println("Invalid Product Name\nEnter Product Name Again : ");
			productName = scanner.next();
		}
		pojo.setProductName(productName);
		System.out.println("Enter the Number of Stock : ");
		int numberOfStock = check.numberValidation();
		pojo.setNumberOfStock(numberOfStock);
		System.out.println("Enter the Stocked Date (dd/mm/yyyy): ");
		String stockedDate = scanner.next();
		while (!check.dateValidation(stockedDate)) {
			System.err.println("Invalid Date Format\nEnter the Stocked Date Again : ");
			stockedDate = scanner.next();
		}
		pojo.setStockedDate(stockedDate);
		System.out.println("Enter the Price of " + productName + " : ");
		int price = check.numberValidation();
		pojo.setCostPrice(price);

		db.addProduct(pojo);

	}

	public void sqlDetailsRead() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter The ID of The Product to View : ");
		int id = scanner.nextInt();
		while (!check.Numerics(id)) {
			System.err.println("Invalid Data\nAgain Enter The ID of The Product to View : ");
			id = scanner.nextInt();
		}
		db.read(id);

	}

	public void sqlStocksRead(int id1, int id2) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		db.readStock(id1, id2);

	}

	public void sqlAddStock(String name) throws ClassNotFoundException, SQLException {

		System.out.println(db.retrieveStock(name));
		int updatedStock = db.retrieveStock(name) + update(name);
		System.out.println("Updated Stock is : " + updatedStock);
		db.updateDb(updatedStock, name);
	}

	public void sqlRemoveStock() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter The Product Name to Delete : ");
		String name = scanner.nextLine();
		while (!db.validRead(name)) {
			System.err.println("Invalid Data\nEnter The Product Name to Delete : ");
			name = scanner.nextLine();
		}
		db.delete(name);
	}

	public void orderStock(int id) throws ClassNotFoundException, SQLException {
		System.out.println("Would You Like to Order The Stocks(y or n) : ");
		String ch = stockMethods.next();

		if (ch.toLowerCase().equals("y")) {
			System.out.println("Enter The Number of Products to Order : ");
			int stockOrder = stockMethods.nextInt();

			db.updateOrder(stockOrder, id);
			Random random = new Random();
			System.err.println("It would take " + random.nextInt(1, 10) + " Days to deliver the Order.");
		}
	}

}
