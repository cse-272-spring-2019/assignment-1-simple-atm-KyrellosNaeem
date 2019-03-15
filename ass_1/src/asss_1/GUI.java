package asss_1;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	public static void main(String[] args) {
		launch(args);
	
	}
	public void start(Stage primaryStage) throws Exception {
		BankAccount a;

		a= new BankAccount(123, 0);
		primaryStage.setTitle("login");
		
		Label cardnumberLabel = new Label("Card number");
		TextField cardNumberField =new TextField();
		Button submit = new Button("submit");
		Label loginLabel = new Label();
		
		GridPane grid =new GridPane();
		grid.add(cardnumberLabel,0,0);
		grid.add(cardNumberField,1,0);
		grid.add(submit,1,1);
		grid.add(loginLabel,1,2);
		
		Scene scene = new Scene(grid,250,150);
		primaryStage.setScene(scene);
		
		
		Button withdrawal = new Button("withdrawal");
		Button Deposit = new Button("Deposit");
		Button Balanceinquiry = new Button("Balanceinquiry");
		Button next = new Button("next");
		Button previous = new Button("previous");
		Button confirmD = new Button("confirm");
		Button confirmW = new Button("confirm");
		Label enteramountLabel = new Label("Enter amount");
		Label balanceLabel = new Label();
		TextField amountField = new TextField();
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		
		GridPane grid2 = new GridPane();
		grid2.add(withdrawal,0,0);
		grid2.add(Deposit,0,1);
		grid2.add(Balanceinquiry,0,2);
		grid2.add(next,0,3);
		grid2.add(previous,0,4);
		grid2.add(enteramountLabel,1,1);
		grid2.add(amountField, 2, 1);
		grid2.add(confirmD,2,2);
		grid2.add(confirmW,2,2);
		grid2.add(balanceLabel, 2, 3);
		grid2.add(one, 4, 1);
		grid2.add(two, 5, 1);
		grid2.add(three, 6, 1);
		grid2.add(four, 4, 2);
		grid2.add(five, 5, 2);
		grid2.add(six, 6, 2);
		grid2.add(seven, 4, 3);
		grid2.add(eight, 5, 3);
		grid2.add(nine, 6, 3);
		grid2.add(zero, 5, 4);
		
		Scene scene2 = new Scene(grid2,400,150);
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				Long cr =Long.valueOf(cardNumberField.getText());
				boolean l= a.Login(cr) ;
				if(l == true) {
					primaryStage.setTitle("ATM");
					loginLabel.setText("true");
					primaryStage.setScene(scene2);
					confirmD.setVisible(false);
					confirmW.setVisible(false);
					enteramountLabel.setVisible(false);
					amountField.setVisible(false);
					balanceLabel.setVisible(false);
					zero.setVisible(false);
					one.setVisible(false);
					two.setVisible(false);
					three.setVisible(false);
					four.setVisible(false);
					five.setVisible(false);
					six.setVisible(false);
					seven.setVisible(false);
					eight.setVisible(false);
					nine.setVisible(false);
					
				}
				else {
					loginLabel.setText("wrong card number");
				}
			}
		});
		
        withdrawal.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				balanceLabel.setVisible(false);
				confirmW.setVisible(true);
				enteramountLabel.setVisible(true);
				amountField.setVisible(true);
				zero.setVisible(true);
				one.setVisible(true);
				two.setVisible(true);
				three.setVisible(true);
				four.setVisible(true);
				five.setVisible(true);
				six.setVisible(true);
				seven.setVisible(true);
				eight.setVisible(true);
				nine.setVisible(true);
				amountField.setText(null);
				
			}
		});
		Deposit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				balanceLabel.setVisible(false);
				confirmD.setVisible(true);
				enteramountLabel.setVisible(true);
				amountField.setVisible(true);
				zero.setVisible(true);
				one.setVisible(true);
				two.setVisible(true);
				three.setVisible(true);
				four.setVisible(true);
				five.setVisible(true);
				six.setVisible(true);
				seven.setVisible(true);
				eight.setVisible(true);
				nine.setVisible(true);
				amountField.setText(null);
				
			}
		});	
		Balanceinquiry.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				confirmD.setVisible(false);
				confirmW.setVisible(false);
			    enteramountLabel.setVisible(false);
		    	amountField.setVisible(false);
				String balance = String.valueOf(a.getBalance());
				balanceLabel.setText(balance);
				balanceLabel.setVisible(true);
				zero.setVisible(false);
				one.setVisible(false);
				two.setVisible(false);
				three.setVisible(false);
				four.setVisible(false);
				five.setVisible(false);
				six.setVisible(false);
				seven.setVisible(false);
				eight.setVisible(false);
				nine.setVisible(false);
				amountField.setText(null);
				
			}
		});
				
		confirmD.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int am =Integer.valueOf(amountField.getText());
				a.Deposit(am);
				amountField.setText(null);
			}
		});
		confirmW.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int am =Integer.valueOf(amountField.getText());
				a.Withdrawal(am);
				amountField.setText(null);
			}
		});
		next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				balanceLabel.setText(a.next());
				zero.setVisible(false);
				one.setVisible(false);
				two.setVisible(false);
				three.setVisible(false);
				four.setVisible(false);
				five.setVisible(false);
				six.setVisible(false);
				seven.setVisible(false);
				eight.setVisible(false);
				nine.setVisible(false);
			}
		});
		previous.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				balanceLabel.setText(a.back());
				zero.setVisible(false);
				one.setVisible(false);
				two.setVisible(false);
				three.setVisible(false);
				four.setVisible(false);
				five.setVisible(false);
				six.setVisible(false);
				seven.setVisible(false);
				eight.setVisible(false);
				nine.setVisible(false);
			}
		});
		zero.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("0");
				else
					amountField.setText(amountField.getText()+0);
			}
		});
		one.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("1");
				else
					amountField.setText(amountField.getText()+1);
			}
		});
		two.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("2");
				else
					amountField.setText(amountField.getText()+2);
			}
		});
		three.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("3");
				else
					amountField.setText(amountField.getText()+3);
			}
		});
		four.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("4");
				else
					amountField.setText(amountField.getText()+4);
			}
		});
		five.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("5");
				else
					amountField.setText(amountField.getText()+5);
			}
		});
		six.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("6");
				else
					amountField.setText(amountField.getText()+6);
			}
		});
		seven.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("7");
				else
					amountField.setText(amountField.getText()+7);
			}
		});
		eight.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("8");
				else
					amountField.setText(amountField.getText()+8);
			}
		});
		nine.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(amountField.getText()==null)
					amountField.setText("9");
				else
					amountField.setText(amountField.getText()+9);
			}
		});
		
		primaryStage.show();

	}

}
