package com.infinite.tasks;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class DifferenceBetweenDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the start date (yyyy-MM-dd HH:mm:ss):");
		String startDateString = scanner.nextLine();
		System.out.println("Enter the end date (yyyy-MM-dd HH:mm:ss):");
		String endDateString = scanner.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		 try{
			 Date startDate = dateFormat.parse(startDateString);
			 Date endDate = dateFormat.parse(endDateString);
			 long differenceInMilliseconds = endDate.getTime() - startDate.getTime();
			 long differenceInminutes = TimeUnit.MILLISECONDS.toMinutes(differenceInMilliseconds);
			 long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliseconds);
			 
			 System.out.println("Difference in days:" + differenceInDays +" days");
			 System.out.println("Difference in minutes:" + differenceInminutes +" minutes ");
			 
		 }catch (ParseException e){
			 System.out.println("Invalid date format.please enter dates in the correct format(yyyy-MM-dd HH:mm:ss).");
		 }

	}

}
