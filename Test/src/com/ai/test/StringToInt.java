package com.ai.test;

import java.util.Scanner;

public class StringToInt {
	public static void main(String args[]) {
		System.out.println("Please enter an integer number");
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		int i = Integer.parseInt(input);
		System.out.println("String converted to int : " + i);
		System.out.println("Please enter another integer number");
		String str = scnr.nextLine();
		int j = Integer.valueOf(str);
		System.out.println("String converted to int : " + j);
	}
}
