package ATM;

import java.util.ArrayList;
import javafx.*;

public class Transactions extends ATM {
	int count;
	ArrayList historyNavigation = new ArrayList();

	public void withdraw(String withdrawalAmount) {
		double balance = Double.parseDouble(getCurrentBalance());
		double amountToWithdraw = Double.parseDouble(withdrawalAmount);

		if (amountToWithdraw <= balance) {
			setValidation(true);
			balance -= amountToWithdraw;

			historyNavigation.add("You withdrew " + amountToWithdraw);
			count++;
			String postWithdrawalBalance = Double.toString(balance);
			setCurrentBalance(postWithdrawalBalance);

		} else {
			setValidation(false);
		}
	}

	public void deposit(String depositAmount) {
		double balance = Double.parseDouble(getCurrentBalance());
		double amountToDeposit = Double.parseDouble(depositAmount);
		balance += amountToDeposit;
		historyNavigation.add("You deposited " + amountToDeposit);
		count++;

		String postDepositBalance = Double.toString(balance);
		setCurrentBalance(postDepositBalance);
	}

	public void balanceInquiry() {
		historyNavigation.add("Your balance is " + getCurrentBalance());
		count++;

	}

	public String previous() {

		return (historyNavigation.get(--count).toString());
	}

	public String next() {
		return (historyNavigation.get(++count).toString());

	}
}
