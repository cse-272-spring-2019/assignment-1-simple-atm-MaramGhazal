package ATM;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ATMapp extends Application {
	Stage stage;
	Scene login;
	Scene mainMenu;
	Scene withdrawing;
	Scene depositing;
	Scene balanceInquiry;
	Scene previous;
	Scene next;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Transactions transactions = new Transactions();
		primaryStage.setTitle("THE ATM APPLICATION");

		// Login Scene

		Label cardNumberLabel = new Label(" Please enter your card number: ");
		cardNumberLabel.setFont(Font.font("Calibri", 20));
		Alert validationAlert = new Alert(AlertType.WARNING);
		TextField cardNumberField = new TextField();
		Button ENTER1 = new Button("ENTER");
		GridPane.setHalignment(ENTER1, HPos.CENTER);
		GridPane loginGrid = new GridPane();
		loginGrid.add(cardNumberLabel, 0, 0);
		loginGrid.add(cardNumberField, 1, 0);
		loginGrid.add(ENTER1, 1, 1);

		ENTER1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String cardNumber = cardNumberField.getText();
				if (cardNumber.equals("5467")) {
					primaryStage.setScene(mainMenu);

				} else {
					validationAlert.setTitle("WARNING");
					validationAlert.setHeaderText("INVALID CARD NUMBER\nPlease try again");
					validationAlert.showAndWait();
				}
			}
		});

		login = new Scene(loginGrid, 450, 90);

		// Menu Scene

		Label welcomeLabel = new Label("   WELCOME TO THE ATM MACHINE");
		welcomeLabel.setAlignment(Pos.CENTER_RIGHT);
		welcomeLabel.setFont(Font.font("Albertus Extra Bold", 15));
		welcomeLabel.setTextFill(Color.web("#0000FF"));
		Label menuLabel = new Label("           Main Menu");
		menuLabel.setAlignment(Pos.CENTER_RIGHT);
		menuLabel.setFont(Font.font("Calibri", 30));

		Button withdrawalButton = new Button("1. Withdrawal");
		GridPane.setHalignment(withdrawalButton, HPos.CENTER);
		Button depositButton = new Button("2. Deposit");
		GridPane.setHalignment(depositButton, HPos.CENTER);
		Button balanceInquiryButton = new Button("3. Balance Inquiry");
		GridPane.setHalignment(balanceInquiryButton, HPos.CENTER);
		Button previousButton = new Button("4. Previous");
		GridPane.setHalignment(previousButton, HPos.CENTER);
		Button nextButton = new Button("5. Next");
		GridPane.setHalignment(nextButton, HPos.CENTER);

		GridPane menuGrid = new GridPane();
		menuGrid.add(welcomeLabel, 0, 0);
		menuGrid.add(menuLabel, 0, 1);
		menuGrid.add(withdrawalButton, 0, 2);
		menuGrid.add(depositButton, 0, 3);
		menuGrid.add(balanceInquiryButton, 0, 4);
		menuGrid.add(previousButton, 0, 5);
		menuGrid.add(nextButton, 0, 6);

		withdrawalButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(withdrawing);

			}

		});

		depositButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(depositing);

			}

		});
		balanceInquiryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(balanceInquiry);

			}

		});

		nextButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(next);
			}

		});

		mainMenu = new Scene(menuGrid, 300, 200);

		// Withdrawing Scene
		Label withdrawalLabel = new Label("Please enter the amount you want to withdraw");
		withdrawalLabel.setFont(Font.font("Calibri", 20));
		TextField withdrawalField = new TextField();
		Label withdrawalResLabel = new Label();
		Alert alert = new Alert(AlertType.WARNING);
		Button ENTER2 = new Button("ENTER");
		GridPane.setHalignment(ENTER2, HPos.CENTER);
		Button Continue1 = new Button("CONTINUE");
		GridPane.setHalignment(Continue1, HPos.CENTER);
		GridPane withdrawalGrid = new GridPane();
		withdrawalGrid.add(withdrawalLabel, 0, 0);
		withdrawalGrid.add(withdrawalField, 0, 1);
		withdrawalGrid.add(ENTER2, 0, 2);
		withdrawalGrid.add(withdrawalResLabel, 0, 3);
		withdrawalGrid.add(Continue1, 0, 4);

		ENTER2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String withdrawalAm = withdrawalField.getText();
				transactions.withdraw(withdrawalAm);
				if (transactions.isValidation()) {
					withdrawalResLabel.setText(
							"You successfully withdrew " + Double.parseDouble(withdrawalAm) + "\nYour new balance is "
									+ transactions.getCurrentBalance() + "\nPlease collect your money");
					withdrawalLabel.setTextFill(Color.web("#0000FF"));
					withdrawalResLabel.setAlignment(Pos.CENTER_RIGHT);
					withdrawalResLabel.setFont(Font.font("Calibri", 20));

				} else {
					alert.setTitle("OPERATION FAILED!");
					alert.setHeaderText(
							"The withdrawal amount is greater than your current balance.\nPlease try again.");
					alert.showAndWait();
				}

			}
		});

		Continue1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(mainMenu);

			}

		});

		withdrawing = new Scene(withdrawalGrid, 400, 200);

		// Depositing Scene

		Label depositLabel = new Label(" Please enter the amount you want to deposit");
		depositLabel.setFont(Font.font("Calibri", 20));
		TextField depositField = new TextField();
		Label depositResLabel = new Label();
		Button ENTER3 = new Button("ENTER");
		GridPane.setHalignment(ENTER3, HPos.CENTER);
		Button Continue2 = new Button("CONTINUE");
		GridPane.setHalignment(Continue2, HPos.CENTER);

		GridPane depositingGrid = new GridPane();
		depositingGrid.add(depositLabel, 0, 0);
		depositingGrid.add(depositField, 0, 1);
		depositingGrid.add(ENTER3, 0, 2);
		depositingGrid.add(depositResLabel, 0, 3);
		depositingGrid.add(Continue2, 0, 4);

		ENTER3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String depositAm = depositField.getText();
				transactions.deposit(depositAm);
				depositResLabel.setText("You successfully deposited " + Double.parseDouble(depositAm)
						+ "\nYour new balance is " + transactions.getCurrentBalance());
				depositLabel.setTextFill(Color.web("#0000FF"));
				depositResLabel.setAlignment(Pos.CENTER_RIGHT);
				depositResLabel.setFont(Font.font("Calibri", 20));

			}

		});

		Continue2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(mainMenu);
			}

		});

		depositing = new Scene(depositingGrid, 380, 200);

		// Balance Inquiry Scene
		Label showYourBalanceLabel = new Label("Click show to view your balance");
		showYourBalanceLabel.setFont(Font.font("Calibri", 20));
		Button showYourBalance = new Button("Show");
		GridPane.setHalignment(showYourBalance, HPos.RIGHT);
		Label yourBalanceLabel = new Label();
		Button Continue3 = new Button("CONTINUE");
		GridPane.setHalignment(Continue3, HPos.CENTER);

		GridPane balanceInquiryGrid = new GridPane();
		balanceInquiryGrid.add(showYourBalanceLabel, 0, 0);
		balanceInquiryGrid.add(showYourBalance, 1, 0);
		balanceInquiryGrid.add(yourBalanceLabel, 0, 1);
		balanceInquiryGrid.add(Continue3, 0, 2);

		showYourBalance.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				yourBalanceLabel.setText("Your balance is " + transactions.getCurrentBalance());
				yourBalanceLabel.setTextFill(Color.web("#0000FF"));
				yourBalanceLabel.setFont(Font.font("Calibri", 20));
			}

		});

		Continue3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(mainMenu);

			}

		});

		balanceInquiry = new Scene(balanceInquiryGrid, 350, 80);

		primaryStage.setScene(login);
		primaryStage.show();

	}
}
