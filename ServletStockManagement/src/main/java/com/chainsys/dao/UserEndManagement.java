package com.chainsys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.util.ConnectUtil;

class Check {
	
	static ValidationChecker validate = new ValidationChecker();
	public static void check(String phNumber) throws PhoneNumberRange {

		String message = "";
		if (validate.phoneNumber(phNumber)) {
			System.out.println("Valid Phone Number!!!");
		} else {
			throw new PhoneNumberRange(message);
		}
	}
}



public class UserEndManagement {

	public static void userEndManagement() throws ClassNotFoundException, SQLException, PhoneNumberRange {
		Scanner UserEnd = new Scanner(System.in);
		ValidationChecker check = new ValidationChecker();
		ServerManager db = new ServerManager();
		ArrayList list = new ArrayList();
		StockModules sm = new StockModules();

		int totalAmount = 0;

		System.out.println("Enter Your Name : ");
		String customerName = UserEnd.next();
		while (!check.str(customerName)) {
			System.err.println("UserName Should Only Contain Alphabets\nEnter Your Name Again : ");
			customerName = UserEnd.next();
		}

		System.out.println("Enter Your PhoneNumber : ");
		String phNumber = UserEnd.next();

		boolean loopStop = true;

		while (loopStop) {
			try {
				Check.check(phNumber);
				loopStop = false;
			} catch (PhoneNumberRange e) {
				System.out.println("Enter Your PhoneNumber Again : ");
				phNumber = UserEnd.next();
			}
		}

		System.out.println("1 ---> Enter 1 to Purchase\n2 ---> Enter 2 to Quit");
		int choose = check.IoMismatch2();

		boolean stop = true;
		while (stop) {
			if (choose == 1) {
				System.out.println("\nChoose The Department");
				System.out.println("0 ---> Quit\n1 ---> Mobile\n2 ---> Fruits\n3 ---> Jewellery");
				int opt = check.IoMismatch4();

				if (opt == 0) {
					System.out.println("****************************");
					System.out.println("Customer Name : " + customerName);
					System.out.println("Phone Number : " + phNumber);
					System.out.println("*****Products Purchased*****");
					System.out.println(list.toString());
					System.out.println("Bill Amount is : " + totalAmount);
					System.out.println("****************************");

					break;
				}
				if (opt == 1) {
					System.out.println("\nChoose The Mobile To View Stock");

					ServerManager.readStock(101, 200);
					System.out.println("Choose the Product ID to purchase : ");
					int purchase = UserEnd.nextInt();
					while (purchase <= 100 || purchase >= 201) {
						System.err.println("Invalid ID\nChoose the Product ID to purchase : ");
						purchase = UserEnd.nextInt();
					}
					System.out.println("Choose Number of Products to Purchase : ");
					int purchaseCount = UserEnd.nextInt();

					if (db.retrieveStockUsingId(purchase) <= 0 || db.retrieveStockUsingId(purchase) < purchaseCount) {
						System.err.println("!!!Out of Stock!!!");
						sm.orderStock(purchase);
					} else {
						db.updateStockCount(purchaseCount, purchase);
						list.add(ServerManager.displayStock(purchase));
						System.out.println(list);
						int purchasedStock = db.retrieveStockUsingId(purchase) - purchaseCount;
						db.updateStock(purchasedStock, purchase);

						totalAmount += (ServerManager.amountCalculate(purchase) * purchaseCount);
					}

				} else if (opt == 2) {
					System.out.println("\nChoose The Fruits To View Stock");

					ServerManager.readStock(201, 300);
					System.out.println("Choose the Product ID to purchase : ");
					int purchase = UserEnd.nextInt();
					while (purchase <= 200 || purchase >= 301) {
						System.err.println("Invalid ID\nChoose the Product ID to purchase : ");
						purchase = UserEnd.nextInt();
					}
					System.out.println("Choose Number of Products to Purchase : ");
					int purchaseCount = UserEnd.nextInt();

					if (db.retrieveStockUsingId(purchase) <= 0 || db.retrieveStockUsingId(purchase) < purchaseCount) {
						System.err.println("!!!Out of Stock!!!");
						sm.orderStock(purchase);

					} else {
						db.updateStockCount(purchaseCount, purchase);
						list.add(ServerManager.displayStock(purchase));
						System.out.println(list);
						int purchasedStock = db.retrieveStockUsingId(purchase) - purchaseCount;
						db.updateStock(purchasedStock, purchase);

						totalAmount += (ServerManager.amountCalculate(purchase) * purchaseCount);
					}

				} else if (opt == 3) {
					System.out.println("\nChoose The Jewel To View Stock");

					ServerManager.readStock(301, 400);
					System.out.println("Choose the Product ID to purchase : ");
					int purchase = UserEnd.nextInt();
					while (purchase <= 300 || purchase >= 401) {
						System.err.println("Invalid ID\nChoose the Product ID to purchase : ");
						purchase = UserEnd.nextInt();
					}
					System.out.println("Choose Number of Products to Purchase : ");
					int purchaseCount = UserEnd.nextInt();

					if (db.retrieveStockUsingId(purchase) <= 0 || db.retrieveStockUsingId(purchase) < purchaseCount) {
						System.err.println("!!!Out of Stock!!!");
						sm.orderStock(purchase);
					} else {
						
						db.updateStockCount(purchaseCount, purchase);
						list.add(ServerManager.displayStock(purchase));
						System.out.println(list);
						int purchasedStock = db.retrieveStockUsingId(purchase) - purchaseCount;
						db.updateStock(purchasedStock, purchase);

						totalAmount += (ServerManager.amountCalculate(purchase) * purchaseCount);
					}

				}
			} else if (choose == 2) {
				stop = false;
			}
		}
	}
}
