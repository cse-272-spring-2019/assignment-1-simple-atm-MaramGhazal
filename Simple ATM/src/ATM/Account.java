package ATM;

import java.util.Scanner;

public class Account {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ATM user = new Transactions();
		System.out.println("***WELCOME TO THE ATM MACHINE***");
		System.out.println("Please enter your card number:");
		user.setCardNumber(scan.next());
		user.validateCardNumber(user.getCardNumber());

		if (user.validateCardNumber(user.getCardNumber()) == false) {

			System.out.println("INVALID CARD NUMBER.");
			System.out.println("Please enter your card number again:");
			user.setCardNumber(scan.next());
			user.validateCardNumber(user.getCardNumber());
		}

		while (true) {
			user.mainMenu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Please enter the amount you want to withdraw:");
				user.withdraw(scan.next());
				System.out.println("Your new balance is " + user.getCurrentBalance());
				break;

			case 2:
				System.out.println("Please enter the amount you want to deposit:");
				user.deposit(scan.next());

				System.out.println("Your new balance is " + user.getCurrentBalance());
				break;

			case 3:
				user.balanceInquiry();
				System.out.println("Your current balance is " + user.getCurrentBalance());
				break;

			case 4:
				user.previous();
				break;

			case 5:
				user.next();
				break;

			}
			if (choice < 1 || choice > 5) {
				System.out.println("INVALID OPTION.");
			}
		}
	}
}
