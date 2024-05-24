package com.chainsys.stockmanagement;

import java.io.FileWriter;
import java.nio.file.Files;

public class Practice1 {

	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("D:\\practice2.txt");
			
			writer.write("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
