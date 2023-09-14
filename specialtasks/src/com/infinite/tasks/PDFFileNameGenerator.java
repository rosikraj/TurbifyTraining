package com.infinite.tasks;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class PDFFileNameGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pdfFileName = generatePDFFileName();
		
		System.out.println("Generated PDF filename: " + pdfFileName);
		
	}
	public static String generatePDFFileName(){
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	try{
		String formattedDate = dateFormat.format(currentDate);
		String filenamePrefix = "Infi";
		String pdfFileName = formattedDate + "_"+ filenamePrefix + ".pdf";
		return pdfFileName;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
    
}
