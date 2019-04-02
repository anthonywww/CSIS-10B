package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BankReadFile {

	public static void main(String[] args) {
		//
		// Create an instance of File for data.txt file.
		//

		File file = new File("src/lab7/bankData.txt");
		Scanner scanner;
		BankAccount[] bankAccount = new BankAccount[10];
		int k = 0;
		
		try {
			//
			// Create a new Scanner object which will read the data
			// from the file passed in. To check if there are more
			// line to read from it we check by calling the
			// scanner.hasNextLine() method. We then read line one
			// by one till all line is read.
			//
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				bankAccount[k] = new BankAccount(scanner);
				System.out.println(bankAccount[k].toString());
				k++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(bankAccount));

		// STEP 9 modify BankAccount so it implements Comparable<BankAccount>
		// Then ADD Statements here to sort your array and display by account number
		Arrays.sort(bankAccount, 0, k);
		System.out.println(Arrays.toString(bankAccount));
		
		// Then ADD Statements to sort your array by balance
		BankAccount.setCompareType(BankAccount.CompareType.COMPARE_BALANCE);
		Arrays.sort(bankAccount, 0, k);
		System.out.println(Arrays.toString(bankAccount));
	}
}
