package lab7;

import java.util.Scanner;

// A simple example, using an association-like record.
// (c) 2001 duane a. bailey
/**
 * An overly simplified implementation of a bank account @author, 2001 duane a.
 * bailey
 * 
 * @version $Id: BankAccount.java 8 2006-08-02 19:03:11Z bailey $
 */
public class BankAccount implements Comparable<BankAccount> {
	
	private static CompareType compareType = CompareType.COMPARE_ACCOUNT;
	protected String account; // the account number
	protected double balance; // the balance associated with account

	/**
	 * @pre account is a string identifying the bank account balance is the starting
	 *      balance
	 * @post constructs a bank account with desired balance
	 */
	public BankAccount(String acc, double bal) {
		account = acc;
		balance = bal;
	}

	public BankAccount(Scanner s) {
		account = s.next();
		balance = s.nextDouble();
	}

	public BankAccount() {
		account = "";
		balance = 0;
	}

	/**
	 * Compare two Bank Accounts (non-standard equals form)
	 * 
	 * @pre other is a valid bank account
	 * @post returns true if this bank account is the same as other
	 */
	public boolean equals(Object other) {
		BankAccount that = (BankAccount) other;
		// two accounts are the same if account numbers are the same
		return this.account.equals(that.account);
	}

	/**
	 * Account accessor.
	 * 
	 * @post returns the bank account number of this account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Balance accessor.
	 * 
	 * @post returns the balance of this bank account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Deposit mutator.
	 * 
	 * @post deposit money in the bank account
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}

	/**
	 * Withdrawal mutator.
	 * 
	 * @pre there are sufficient funds in the account
	 * @post withdraw money from the bank account
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public String toString() {
		return account + ":   " + balance;
	}

	public void readFromFile(Scanner s) {
		account = s.next();
		balance = s.nextDouble();
	}
	
	public static void setCompareType(CompareType type) {
		compareType = type;
	}
	
	public static CompareType getCompareType() {
		return compareType;
	}

	@Override
	public int compareTo(BankAccount o) {
		if (compareType == CompareType.COMPARE_ACCOUNT) {
			return account.compareTo(o.account);
		} else if (compareType == CompareType.COMPARE_BALANCE) {
			return Double.compare(balance, o.balance);
		}
		return 0;
	}
	
	public static enum CompareType {
		COMPARE_ACCOUNT, COMPARE_BALANCE
	}
	
}
