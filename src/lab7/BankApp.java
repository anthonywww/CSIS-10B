package lab7;

/**
 * Method to test Bank Accounts. Is it better to invest $100 over 10 years at
 * 5%, or to invest $100 over 20 years at 2.5%?
 */
public class BankApp {
	public static void main(String[] args) {
		// Question: is it better to invest $100 over 10 years at 5%
		// or to invest $100 over 20 years at 2.5% interest?
		BankAccount jd = new BankAccount("Jain Dough", 100.00);
		BankAccount js = new BankAccount("Jon Smythe", 100.00);

		for (int years = 0; years < 10; years++) {
			jd.deposit(jd.getBalance() * 0.05);
		}
		for (int years = 0; years < 20; years++) {
			js.deposit(js.getBalance() * 0.025);
		}
		System.out.println("Jain invests $100 over 10 years at 5%.");
		System.out.println("After 10 years " + jd.getAccount() + " has $" + jd.getBalance());
		System.out.println("Jon invests $100 over 20 years at 2.5%.");
		System.out.println("After 20 years " + js.getAccount() + " has $" + js.getBalance());
	}
}