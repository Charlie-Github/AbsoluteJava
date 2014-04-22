package contactDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ContactsApplication {

	/*Global variables*/
	static Database contactsDatabase;
	
	public static void main(String[] args) {
		//User interface
		/*//test section
		createAccount();
		deposit(100,new Money(1,1));
		deposit(100,new Money(2,2));
		deposit(100,new Money(3,3));
		withdraw(100,new Money(1,1));
		viewHistory(100);
		*/
		contactsDatabase = new Database();
		
		
		System.out.println("Contacts System V1.0");
		
		System.out.println("\n--------------Select a task below-------------");
		System.out.println("0: Add New Contact\t\t1: Show All ");
		System.out.println("2: Search Contact\t\t3: Delete Contact");
		
		System.out.println("7: Exit");

		
		while(true){
			inputCommand();
		}
	}
	
	
	public static void inputCommand(){
		System.out.println("\n0:Add 1:All 2:Search 3:Delete 7:EXIT ");
		Scanner scCommand = new Scanner(System.in);
		System.out.print("=>");
		String inputCommand = scCommand.next();
		
		
		
		
		if(inputCommand.equals("0")){
			System.out.println("Action: new contact");
			System.out.print("First Name=>");
			String first = scCommand.next();
			System.out.print("Last Name=>");
			String last = scCommand.next();
			System.out.print("Phone Number=>");
			String num = scCommand.next();
			System.out.print("Email=>");
			String email = scCommand.next();
			createContact(first, last, num, email);
		}
		else if(inputCommand.equals("1")){
			System.out.println("Action: Show All");
			contactsDatabase.showAll();
			
		}
		else if(inputCommand.equals("2")){
			System.out.println("Action: withdraw");
			System.out.println("-account number:");
			System.out.print("=>");
			int accountNum = scCommand.nextInt();

			System.out.println("-money:");
			System.out.print("=>");
			String inputMoney = scCommand.next();
			
			String[] moneyParts = inputMoney.split("\\.");			
			int dollars = 0;
			int cents = 0;
			if(moneyParts.length != 2){
				dollars = Integer.parseInt(moneyParts[0]);
				cents = 0;
			}
			else{
				dollars = Integer.parseInt(moneyParts[0]);
				cents = Integer.parseInt(moneyParts[1]);
			}
			
			if(cents < 10){
				cents = cents *10;
			}
			
			//withdraw(accountNum,new Money(dollars,cents));
			System.out.println("Action: withdraw done");
		}
		else if(inputCommand.equals("3")){
			System.out.println("Action: check balance");
			System.out.println("-account number:");
			System.out.print("=>");
			int accountNum = scCommand.nextInt();
			System.out.print("-account " + accountNum +" balance: ");
			//System.out.println(checkBalance(accountNum));
			System.out.println("Action: check balance done");
		}
		else if(inputCommand.equals("4")){
			System.out.println("Action: view history");
			System.out.println("-account number:");
			System.out.print("=>");
			int accountNum = scCommand.nextInt();
			//viewHistory(accountNum);
			System.out.println("Action: show done");
		}
		else if(inputCommand.equals("5")){
			System.out.println("Action: calculate total");
			//calcTotal();
			System.out.println("Action: calculate done");
		}
		else if(inputCommand.equals("6")){
			System.out.println("Action: show account list");
			//showAccountList();
			System.out.println("Action: show done");
		}			
		else if(inputCommand.equals("7")){
			
			System.out.println("Exit...");
			System.exit(0);
			
		}
		else{
			System.out.println("Error: Invalid Command");
		}
	}
	
	public static void createContact(String first, String last, String num, String email){
		Contacts newContact = new Contacts(first,last,num,email);		
	}
	
	
	
	

	
	
	

}
