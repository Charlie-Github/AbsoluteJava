package contactDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
	//int accountNum;
	ArrayList<Contacts> contacts;
	
	
	public Database(){
		//constructor
		//accountNum = newNum;		
		//transactions = new ArrayList<Transaction>();
		contacts = new ArrayList<Contacts>();
	}
		
	
		
	public void addContact(String first, String last, String num, String email){
		Contacts newContact = new Contacts(first,last,num,email);
		contacts.add(newContact);
		
	}
	
	public void showAll(){
		String first, last, num, email;
		for(Contacts aContact:contacts){
			first = aContact.firstName;
			last = aContact.lastName;
			num = aContact.phoneNum;
			email = aContact.email;
			System.out.print(last+","+first+ "\t|"+num+"\t|"+email+"\n");
		}
	}
	
	public void searchContacts(String name){
		String first, last, num, email;
		for(Contacts aContact:contacts){
			
			first = aContact.firstName;
			last = aContact.lastName;
			num = aContact.phoneNum;
			email = aContact.email;
			
		    Pattern pattern = Pattern.compile("["+(name)+"]+");
		    Matcher matchFirst = pattern.matcher(first);
		    Matcher matchLast = pattern.matcher(last);
			
			if(matchFirst.find()||matchLast.find()){
				System.out.print(last+","+first+ "\t|"+num+"\t|"+email+"\n");
			}
			else{
				System.out.println("No record found.");
			}
			
		}
	}
	
	public void deletContact(String first, String last){
		
		for(Contacts aContact:contacts){
			if (first.equals(aContact.firstName) && last.equals(aContact.lastName)){
				System.out.print(last+","+first+" has been removed!\n");
			}			
			
		}
	}
}
