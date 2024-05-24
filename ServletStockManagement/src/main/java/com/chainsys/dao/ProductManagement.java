package com.chainsys.dao;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductManagement {

	public void productManagement() throws ClassNotFoundException, SQLException {

		Scanner productManagement = new Scanner(System.in);
		StockModules sm = new StockModules();
		ServerManager db = new ServerManager();
		ValidationChecker check = new ValidationChecker();

		boolean run = true;

		while (run) {
			System.out.println(
					"1 ---> View Stock\n2 ---> Add Stock\n3 ---> Remove Stock\n4 ---> Add Stock Details\n5 ---> View High Demand Stock\n6 ---> Inspect Stock\n7 ---> Reset Sold Stock Section\n8 ---> Quit");
			int choose = check.IoMismatchProductManagementOptions();

			if (choose == 1) {
				System.out.println("\nChoose The Department");
				System.out.println("1 ---> Mobile\n2 ---> Fruits\n3 ---> Jewellery\n0 ---> Quit");
				int opt = check.IoMismatchDepartment();

				if (opt == 0) {
					break;
				} else if (opt == 1) {
					System.out.println("\nChoose The Mobile To View Stock");

					db.readStock(101, 200);
				} else if (opt == 2) {
					System.out.println("\nChoose The Fruits To View Stock");

					db.readStock(201, 300);

				} else if (opt == 3) {
					System.out.println("\nChoose The Jewel To View Stock");

					db.readStock(301, 400);

				}
			} else if (choose == 2) {
				System.out.println("Choose The Department To Add Stock\n");

				System.out.println("1 ---> Mobile\n2 ---> Fruits\n3 ---> Jewellery");

				int depChoose = check.IoMismatch3();

				if (depChoose == 1) {
					System.out.println("---Add Stock of Mobiles---");
					db.readStock(101, 200);
					System.out.println("Enter The Name of the Product to Update Stock : ");
					String proName = productManagement.next();
					while (!check.str(proName)) {
						System.err.println("Invalid Data\nEnter The Name of the Product to Update Stock Again: ");
						proName = productManagement.next();
					}
					while (!db.validRead(proName)) {
						System.err.println("Invalid Data\nAgain Enter The Product Name to Update Stock : ");
						proName = productManagement.next();
					}
					sm.sqlAddStock(proName);
				} else if (depChoose == 2) {
					System.out.println("---Add Stock of Fruits---");
					db.readStock(201, 300);
					System.out.println("Enter The Name of the Product to Update Stock : ");
					String proName = productManagement.next();
					while (!check.str(proName)) {
						System.err.println("Invalid Data\nEnter The Name of the Product to Update Stock Again: ");
						proName = productManagement.next();
					}
					sm.sqlAddStock(proName);
				} else if (depChoose == 3) {
					System.out.println("---Add Stock of Jewels---");
					db.readStock(301, 400);
					System.out.println("Enter The Name of the Product to Update Stock : ");
					String proName = productManagement.next();
					while (!check.str(proName)) {
						System.err.println("Invalid Data\nEnter The Name of the Product to Update Stock Again: ");
						proName = productManagement.next();
					}
					sm.sqlAddStock(proName);
				}

			} else if (choose == 3) {

				System.out.println("Choose The Department To Remove Stock\n");

				System.out.println("1 ---> Mobile\n2 ---> Fruits\n3 ---> Jewellery");
				int removeChoose = check.IoMismatch3();

				if (removeChoose == 1) {
					db.readStock(101, 200);
					sm.sqlRemoveStock();
					System.out.println("---Stocks Removed---");
				} else if (removeChoose == 2) {
					db.readStock(201, 300);
					sm.sqlRemoveStock();
					System.out.println("---Stocks Removed---");
				} else if (removeChoose == 3) {
					db.readStock(301, 400);
					sm.sqlRemoveStock();
					System.out.println("---Stocks Removed---");
				}
			}

			else if (choose == 4) {

				System.out.println("Choose The Department To Add the Details\n");
				System.out.println("1 ---> Mobile\n2 ---> Fruits\n3 ---> Jewellery");

				int addDetails = check.IoMismatch3();

				if (addDetails == 1) {
					sm.sqlDetailsWrite();

					System.out.println("---Details Updated---");
				} else if (addDetails == 2) {

					sm.sqlDetailsWrite();

					System.out.println("---Details Updated---");
				} else if (addDetails == 3) {
					sm.sqlDetailsWrite();
					System.out.println("---Details Updated---");
				}

			} else if (choose == 5) {

				db.highDemandStock();

			} else if (choose == 6) {
				db.inspectStock();
			} else if (choose == 7) {
				db.resetSoldStock();
			}else if (choose == 8) {
				run = false;
			}

		}
	}
}
