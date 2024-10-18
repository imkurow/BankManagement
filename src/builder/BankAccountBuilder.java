package builder;

import model.BankAccount;

public class BankAccountBuilder {

	private static BankAccountBuilder instance = null;
	
	private BankAccountBuilder() {
		
	}
	
	public static BankAccountBuilder getInstance() {
		if(instance == null) {
			instance = new BankAccountBuilder();
		}
		return instance;
	}
	
	//copas semua field yang dipakai untuk builder
	private String accountNumber;
	private String name;
	private int DOB;
	private double balance;
	
	
	public BankAccountBuilder setFullName(String fullName) {
		this.name = fullName;
		return this;
	}
	
	public BankAccountBuilder setDOB(int dob) {
		this.DOB = dob;
		return this;
	}
	
	public BankAccountBuilder setBalance(double balance) {
		this.balance = balance;
		return this;
	}
	
	public BankAccount build(){
		BankAccount res = new BankAccount(name, DOB, balance);
		this.name = "";
		this.DOB = 0;
		this.balance = 0;
		return res;
		
	}
	
	
	
}
