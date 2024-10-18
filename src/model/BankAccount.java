package model;

import java.util.Random;

public class BankAccount {
	
	private String accountNumber;
	private String name;
	private int DOB;
	private Double balance;
	
	public String toString() {
		return "accountNumber : " + accountNumber 
				+ "Name : " + name
				+ "Date Of Birth : " + DOB
				+ "Balance : " + balance;
	}
	
	public BankAccount(String name, int dOB2, Double balance) {
		super();
		this.name = name;
		this.DOB = dOB2;
		this.balance = balance;
		this.accountNumber = generateAccountNumber();
	}
	
	private String generateAccountNumber() {
		
		String output = "";
		Random ran = new Random();
		for(int i = 0; i < 8; i++){		
			if(i == 0) {
				//ngerandom dari 1 - 9
				output += abs((ran.nextInt() % 19) + 1);
				
				//ngerandom dari a - z 
//				char randomChar = (char) (abs(ran.nextInt() % 26) + 'a');
//				output += randomChar;
			}
			else {
				output += abs(ran.nextInt() % 10);
			}
		}
		return output;
	}
	
	private int abs(int number) {
		if(number < 0) return number * -1;
		return number;
	}
	
	
	

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDOB() {
		return DOB;
	}
	public void setDOB(int dOB) {
		DOB = dOB;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
	
}
