package com.chainsys.dao;

import java.io.FileReader;
import java.util.Scanner;

import com.chainsys.dao.*;

public class ReadStockDetails implements ReadStockDAO{

	
	
	@Override
	public void readStockDetails(String path, String details) {
		try {
			FileReader reader = new FileReader(path);
			
			Scanner scanner = new Scanner(reader);
			
			while(scanner.hasNextLine())
			{
				String str = scanner.nextLine();
				
				String[] strArr = str.split(" ");
				if(details.equals(strArr[1]))
				{
					System.out.println("ID : " + strArr[0] + "\nProduct Name : " + strArr[1] + "\nStock : " + strArr[2] + "\nStocked Date : "+strArr[3]+"\nAmount : " + strArr[4]);
				}
				
				
			}
			reader.close();
			scanner.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
