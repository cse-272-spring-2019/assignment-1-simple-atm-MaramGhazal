package ATM;

abstract class ATM {
	private String cardNumber;
	private String currentBalance = "0";
	private String validCardNumber = "5467";
	private boolean validation;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getValidCardNumber() {
		return validCardNumber;
	}

	public void setValidCardNumber(String validCardNumber) {
		this.validCardNumber = validCardNumber;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	abstract void withdraw(String withdrawalAmount);

	abstract void deposit(String depositAmount);

	abstract void balanceInquiry();

	abstract String previous();

	abstract String next();

	public boolean validateCardNumber(String cardNumber) {
		if (getCardNumber().equals(getValidCardNumber())) {
			return true;
		} else {
			return false;
		}
	}

	public void mainMenu() {

		System.out.println("\tMain Menu");
		System.out.println("1. Withdrawal");
		System.out.println("2. Deposit");
		System.out.println("3. Balance Inquiry");
		System.out.println("4. Previous");
		System.out.println("5. Next");
		System.out.println("Please select an option:");
	}

}