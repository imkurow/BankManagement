package adapter;

import model.BankAccount;
import model.CreditCard;

public class CreditCardAdapter extends CreditCard{
	
	public CreditCardAdapter(BankAccount bankAccount, double limit) {
		super(bankAccount.getAccountNumber(), bankAccount.getName(), limit);
		
		this.bankAccount = bankAccount;
	}

	public BankAccount bankAccount;
	
}
