package javatest;

import java.util.Scanner;
//Base class for account

public class Account {
	protected String accountId;
	protected String accountName;
	protected String address;
	protected double depositAmount;
	//constructor to initialize account details
	public Account(String accountId, String accountName,String address){
		this.accountId = accountId;
		this.accountName = accountName;
		this.address = address;
		this.depositAmount = 0.0;
		//method to get account details
		
	}
	public  void getDetails(){
		System.out.println("Account ID:"+accountId);
		System.out.println("Account Name:"+accountName);
		System.out.println("Address:"+address);
		System.out.println("Deposit Amount:$"+depositAmount);
		
	}
	////method to get account details
	

	public void showDetails(){
		System.out.println("Account Details:");
		getDetails();
	}
	////method to deposit amount
	public void  depositAmount(double amount){
		depositAmount +=amount;
	}
}
//subclass loan inherits fron account
class Loan extends Account {
	private String loanId;
	private String loanType;
	private double loanAmount;
	
	public Loan(String accountId,String accountName,String address,String loanId,String loanType){
		super(accountId,accountName,address);
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = 0.0;
		
	}
	public void showLoanDetails(){
		System.out.println("Loan details:");
		getLoan();
		
	}
	public void pay																																																																					oan(double amount){
		loanAmount -=amount;
	}
	class Transaction extends Loan{
		public Transaction(String accountId,String accountName,String address,String loanID,String loanType){
			super(accountId,accountName,address,loanId,loanType);
			
		}
		public void showAccountDetails(){
			System.out.println("Account and loan Details:");
			super.showDetails();
			super.showLoanDetails();
		}
	}
	public class Main{
		public static void main(String[] args){
			Account[] accounts = new Account[10];
			accounts[0]=new Transaction("12234567-ASDF","rosik","123 yld","Home");
			accounts[1]=new Transaction("9876543_QWER"-"raj","456 xt","gt","car");
			Scanner scanner = new Scanner(System.in);
			System.out.println("perform Transaction on account 0:");
			System.out.println("Enter deposit amount :$");
			double depositAmount = scanner.nextDouble();
			System.out.println("updated account details:");
			((Transaction) account[0]).showAccountDetails();
			scanner.close();
		}
	}
}