package atmproject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

	public class OptionMenu extends Account {
		Scanner menuInput = new Scanner(System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
		
		HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
		
		public void getLogin() throws IOException {
		    int x = 1;

		    do {
		        try {
		            data.put(9876543, 9876);
		            data.put(8989898, 1890);

		            System.out.println("Welcome to ATM");

		            System.out.println("Enter your Account number: ");
		            setCustomerNumber(menuInput.nextInt());

		            System.out.println("Enter Your pin number: ");
		            setPinNumber(menuInput.nextInt());

		            System.out.println("Debug: Entered Account Number: " + getCustomerNumber());
		            System.out.println("Debug: Entered PIN: " + getPinNumber());

		        } catch (Exception e) {
		            System.out.println("\n" + "Invalid character(s). Only numbers are allowed." + "\n");
		            x = 2;
		            menuInput.nextLine();
		            continue;
		        }

		        boolean found = false;
		        for (Entry<Integer, Integer> entry : data.entrySet()) {
		            System.out.println("Debug: Checking against Account Number: " + entry.getKey() + " and PIN: " + entry.getValue());

		            if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
		                found = true;
		                getAccountType();
		                return;
		            }
		        }

		        if (!found) {
		            System.out.println("\n" + "Wrong customer or pin number." + "\n");
		        }

		    } while (x == 1);
		}


	public void getAccountType() {
			System.out.println("Select the account you want to acces: ");
			System.out.println("Type 1- CHECKING ACCOUNT");
			System.out.println("Type 2- SAVING");
			System.out.println("Type 3- EXIT");
			System.out.print("CHOICE: ");
			
			selection = menuInput.nextInt();
			
			switch (selection) {
			case 1:
				getChecking();
				break;
				
			case 2:
				getSaving();
				break;
				
			case 3:
				System.out.println("Thank you for using atm");
				break;
				
				default:
					System.out.println("\n" + "invalid choice" + "\n");
					getAccountType();
			}
		}
		public double getChecking() {
			System.out.println("Checking the account: ");
			System.out.println("Type 1- VIEW BALANCE");
			System.out.println("Type 2- WITHDRAW FUNDS");
			System.out.println("Type 3- DEPOSIT FUNDS");
			System.out.println("Type 4- EXIT");
			System.out.print("choice: ");
			
			selection = menuInput.nextInt();
			
			switch (selection) {
			case 1:
				System.out.println("checking account balance: " + moneyFormat.format(getChecking()));
				getAccountType();
				break;
				
			case 2:
				getCheckingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getCheckingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thank you for using ATM");
				break;
				
				default:
					System.out.println("\n"+ "invalid choice"+"\n");
					getChecking();
				
				
			}
			return selection;
			
		}
		public void getSaving() {
			System.out.println("Saving account: ");
			System.out.println("Type 1- VIEW BALANCE");
			System.out.println("Type 2- WITHDRAW FUNDS");
			System.out.println("Type 3- DEPOSIT FUNDS");
			System.out.println("Type 4- EXIT");
			System.out.println("choice: ");
			
			selection = menuInput.nextInt();
			
			switch (selection) {
			case 1:
				System.out.println("Saving account balance: "+ moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
				
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
				
			case 3:
				getSavingDepositInput();
				getAccountType();
				break;
				
			case 4:
				System.out.println("Thank you for using ATM");
				break;
				
				default:
					System.out.println("\n"+ "invalid choice"+"\n");
					getSaving();
			}
			
		}
		
		int selection;
		
		
}


