package com.chainsys.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.chainsys.dao.*;
import com.chainsys.model.StockInfo;

public class TestStock extends StockModules {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, PhoneNumberRange {

		Scanner TestStock = new Scanner(System.in);
		ServerManager dbm = new ServerManager();
		ProductManagement pm = new ProductManagement();
		UserEndManagement usm = new UserEndManagement();
		StockInfo pojo = new StockInfo();
		ValidationChecker check = new ValidationChecker();

		System.out.println("1 ---> ProductManager\n2 ---> Customer\n3 ---> Exit");

		int type = check.IoMismatch3();

		if (type == 1) {
			System.out.println("Stock Management System of ABC Store\n");

			System.out.println("1 ---> New User\n2 ---> Already a User\nChoose User Type : ");
			int userType = check.IoMismatch2();

			if (userType == 1) {
				System.out.println("Enter the Admin Name : ");
				String adminName = TestStock.next();
				pojo.setAdminName(adminName);
				System.out.println("Enter the Admin Password : ");
				int adminPassword = TestStock.nextInt();
				pojo.setPassword(adminPassword);

				while(!dbm.retrieveUserCred(pojo))
				{
					System.out.println("UserName Already Exist\nEnter Name Again");
					adminName = TestStock.next();
					pojo.setAdminName(adminName);
					System.out.println("Enter the Admin Password : ");
					adminPassword = TestStock.nextInt();
					pojo.setPassword(adminPassword);
				}
				dbm.insertUserCred(pojo);

			} else if (userType == 2) {
				System.out.println("Enter UserName : ");
				String userName = TestStock.next();
				System.out.println("Enter Password : ");
				int password = check.numberValidation();

				while (!dbm.readUserCred(userName, password)) {
					System.err.println("Wrong UserName or PassWord");
					System.out.println("Enter UserName Again: ");
					userName = TestStock.next();
					System.out.println("Enter Password Again: ");
					password = TestStock.nextInt();
				}
				System.out.println("LoggedIN Successfully\n");

				pm.productManagement();
			}
		} else if (type == 2) {
			usm.userEndManagement();
		}

	}

}