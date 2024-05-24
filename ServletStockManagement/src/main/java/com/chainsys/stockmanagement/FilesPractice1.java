package com.chainsys.stockmanagement;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FilesPractice1 {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter The Number to Write(1) and Read(2) : ");
//		int num = scanner.nextInt();
//		if(num == 1)
//		{
//			write();
//		}
//		if(num == 2)
//		{
//			read(name);
//		}
		
	}
	
	public static void write() {
		try {
			FileWriter writer = new FileWriter("D:\\demo2.txt", true);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter ID : ");
			int id = scanner.nextInt();
			System.out.println("Enter Name : ");
			String name = scanner.next();
			System.out.println("Enter Age : ");
			int age = scanner.nextInt();
			
			String str = id + " " + name + " " + age+"\n";
			
			writer.write(str);
			writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void read(String name) {
		try {
			FileReader reader = new FileReader("D:\\MobilesDetails.txt");
			Scanner scan = new Scanner(System.in);
			Scanner scanner = new Scanner(reader);
//			System.out.println("Enter Name To Search :");
//			String name = scan.nextLine();
			
			while(scanner.hasNextLine())
			{
				
				String str = scanner.nextLine();
				String[] strArr = str.split(" ");
				
				if(strArr[1].equals(name))
				{
					System.out.println("Age : " + strArr[2]);
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
