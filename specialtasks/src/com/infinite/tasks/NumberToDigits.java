package com.infinite.tasks;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToDigits {
		private static final String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		private static final String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		private static final String[] tens = { "","","twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		
		private static final String[] thousandsGroups = { ""," thousand", "million", "billion", "trillon" };
		
		public static String convertToDigits(int number){
			if (number == 0){
				return "zero";
				
			}
			int groupCount =0;
			String result ="";
			
			while (number>0){
				if (number % 1000!=0){
					result = convertToWordsLessThanThousand(number % 1000)+ thousandsGroups[groupCount]+ " "+ result;
				}
				number/=1000;
				groupCount++;
			}
			return result.trim();
		}
		private static String convertToWordsLessThanThousand (int number){
			if (number < 10){
				return units[number];
					
				}else if (number <20){
					return teens[number -10];
					
				}else if (number <100){
					return tens[number /10]+ ((number %10 !=0) ? " " + units[number % 10 ]: "");
					
					
				} 
		else
		{
			return units[number /100]+" hundred"+((number%100 !=0)?" and "+ convertToWordsLessThanThousand(number % 100) : "");
	}}
		
		public static String addCommas(int number) {
			DecimalFormat formatter = new DecimalFormat("#,###");
			return formatter.format(number);
		}
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			try {
			System.out.println("Enter the number: ");
			int inputNumber = scanner.nextInt();
			
			if(inputNumber < 0){
				System.out.println("please enter a non-negative number.");
				return;
			}
			
			String numberWithCommas = addCommas(inputNumber);
			System.out.println("Ouput with commas:" +numberWithCommas);
			
			String numberInWords = convertToDigits((int) inputNumber);
			System.out.println("Output in words: " + numberInWords + " only");
			}catch (InputMismatchException e){
				System.out.println("Invalid input.please enter a valid integer.");
			}
			finally {
				scanner.close();
			}
		}
		
}
