package com.chainsys.stockmanagement;

import java.util.ArrayList;

public class DepartmentUpdater {

	public static void main(String[] args) {
	
		ArrayList<Object> departments = new ArrayList<>();
		
		departments.add(4);
		departments.add("mango");
		departments.add(5);
		departments.add("apple");
		departments.add(6);
		departments.add("orange");
		System.out.println(departments);
		
		Object[] arr = departments.toArray();
		
		for(int i=0; i<arr.length; i+=1)
		{
			System.out.println(arr[i] + " ----> " + arr[i+1]);
			i+=1;
		}
		
	}
		
}
