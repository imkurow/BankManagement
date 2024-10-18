package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adapter.CreditCardAdapter;
import builder.BankAccountBuilder;
import model.BankAccount;
import model.CreditCard;

public class Main {

	private static Scanner scan = new Scanner(System.in);
	private static List<BankAccount> accountList = new ArrayList<>();
	private static boolean stay = true;
	
	public static void getAccountList() {
		int i = 1;
		for(BankAccount account : accountList) {
			System.out.printf("(%d).\n", i);i++;
			System.out.printf("Account Number \t: %s\n", account.getAccountNumber());
			System.out.printf("Owner Name \t: %s\n", account.getName());
			System.out.printf("Owner DOB \t: %d\n", account.getDOB());
			System.out.printf("Balance \t: Rp.%.2f,-\n", account.getBalance());
			System.out.println("===============2===================");
		}
	}
	
	public static void main(String[] args) {
		new Main();

	}
	
	private void cls() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	
	private double getDouble(String text, double min, double max) {
		double output = min - 1;
		do {
			System.out.print(text);
			String sc = scan.nextLine();
			try {
				output = Integer.parseInt(sc);
			} catch (Exception e) {

			}
			
		}while(output < min || output > max);
		return output;
	}
	
	private static int getInt(String text, int min, int max) {
		int output = min-1;
		do {
			System.out.print(text);
			String sc = scan.nextLine();
			try {
				output = Integer.parseInt(sc);
			} catch (Exception e) {

			}
			
		}while(output < min || output > max);
		return output;
	}
	
	private void RegisterCC(BankAccount account, double limit) {
		CreditCardAdapter adapter = new CreditCardAdapter(account, limit);
		CreditCard cc = (CreditCard) adapter;
	}


	private void register() {
		System.out.println("REGISTER PAGE");
		System.out.println("============== ");
		System.out.println("full name : ");
		String name = scan.nextLine();
		
		System.out.println("DOB (must before 2006)");
		int dob = getInt(">>", 1900, 2006);
		
		double sb = getDouble("Starting Balance = ", 50000, Integer.MAX_VALUE);
		
		BankAccountBuilder builder =  BankAccountBuilder.getInstance();
		BankAccount account = builder
				.setFullName(name)
				.setDOB(dob)
				.setBalance(sb)
				.build();
		System.out.println(account.getAccountNumber());
		accountList.add(account);
		
	}
	
	
	
	
	private static void getUsername(BankAccount account) {
		System.out.println("Home Page");
		System.out.println("==================");
		System.out.printf("welcome %s ^-^ \n", account.getName());
		System.out.println();
	}
	
	public static void findName() {
		System.out.print("Enter your name : " );
		String inputname = scan.nextLine();
		boolean found = false;
		for(BankAccount account : accountList) {
			if(inputname.equals(account.getName())) {
				found = true;
				getUsername(account);
				homepage();
//				stay = false;
				break;
			}
		}
		if(!found) {
			System.out.println("account not found");
		}
		
	}
	
	private void login() {
		
		
		System.out.println("LOGIN PAGE");
		System.out.println("===========");
		findName();
		
	}
	private static void homepage() {
		System.out.println("1. View Balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. View Credit Card");
		int opt = getInt(">>", 1, 4);
		switch(opt) {
		case 1: 
			System.out.println("kosong");break;
		case 2:
			System.out.println("mau tf ke siapa");break;
		case 3:
			System.out.println("mau narik berapa");break;
		case 4:
			System.out.println("your credit card information : ");break;
			
		}
	}
	
	public Main() {

		
		do {
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			int input = getInt(">>", 1, 3);
			
			switch(input) {
			case 1:
				login();
				break;
				
			case 2:
				register();
				getAccountList();
				break;
				
			case 3:
				System.out.println("See you later!~");
				stay = false;
				break;
			}
		}
		while(stay);
	}	
}
