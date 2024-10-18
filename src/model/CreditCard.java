package model;

public class CreditCard {
	private String cardNumber;
	private String accountNumber;
	private String fullname;
	private double limit;
	private double usage;
	
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public double getUsage() {
		return usage;
	}
	public void setUsage(double usage) {
		this.usage = usage;
	}
	
	
	
	public CreditCard(String accountNumber, String fullname, double limit) {
		super();
		this.accountNumber = accountNumber;
		this.fullname = fullname;
		this.limit = limit;
		this.usage = 0;
		this.cardNumber = "";
	}
	
	
}
