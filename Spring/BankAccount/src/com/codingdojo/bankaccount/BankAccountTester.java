package com.codingdojo.bankaccount;

public class BankAccountTester {

	public static void main(String[] args) {
		BankAccount myBankAcct = new BankAccount();
		myBankAcct.depositMoney(100.49, "checking");
		myBankAcct.depositMoney(3.00, "savings");
		myBankAcct.displayAccountBalance();

		System.out.println(BankAccount.totalHoldings);

		myBankAcct.withdrawMoney(50, "checking");
		myBankAcct.withdrawMoney(50, "savings");
		myBankAcct.displayAccountBalance();

		System.out.println(BankAccount.totalHoldings);
	}

}
