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
			contactsDatabase.addContact(first, last, num, email);
		}
		else if(inputCommand.equals("1")){
			System.out.println("Action: Show All");
			contactsDatabase.showAll();
			
		}
		else if(inputCommand.equals("2")){
			System.out.println("Action: Search Contacts");
			
			System.out.print("Name=>");
			String name = scCommand.next();		
			contactsDatabase.searchContacts(name);
		}
		else if(inputCommand.equals("3")){
			System.out.println("Action: delete contact");
			System.out.print("First Name=>");
			String first = scCommand.next();
			System.out.print("Last Name=>");
			String last = scCommand.next();
			
			contactsDatabase.deletContact(first, last);
			
			System.out.println("Deleted!");
		}
		else if(inputCommand.equals("7")){
			
			System.out.println("Exit...");
			System.exit(0);
			
		}
		else{
			System.out.println("Error: Invalid Command");
		}
	}
}
