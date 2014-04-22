package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankEmployeeApplication {

	/*Global variables*/
	static int accountNum_global = 52240;
	static ArrayList accounts = new ArrayList();
	static HashMap accountsHash = new HashMap();
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
		
		System.out.println("Charlie's Bank SystemV1.0");
		
		System.out.println("\n--------------Select a task below-------------");
		System.out.println("0: Create Account\t\t1: Deposit ");
		System.out.println("2: Withdraw	\t\t3: Check Balance");
		System.out.println("4: View Account History\t\t5: Calculate total money");
		System.out.println("6: Show accounts list");
		System.out.println("7: Exit");

		
		while(true){
			inputCommand();
		}
	}
	
	
	public static void inputCommand(){
		System.out.println("\n0:Create 1:Depo 2:Withdraw 3:Balance 4:History 5:Total 6:AccList 7:EXIT ");
		Scanner scCommand = new Scanner(System.in);
		System.out.print("=>");
		String inputCommand = scCommand.next();
		
		
		
		
		if(inputCommand.equals("0")){
			System.out.println("Action: new account");
			createAccount();
		}
		else if(inputCommand.equals("1")){
			System.out.println("Action: deposit");
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
			
			
			deposit(accountNum,new Money(dollars,cents));
			
			System.out.println("Action: deposit done");
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
			
			withdraw(accountNum,new Money(dollars,cents));
			System.out.println("Action: withdraw done");
		}
		else if(inputCommand.equals("3")){
			System.out.println("Action: check balance");
			System.out.println("-account number:");
			System.out.print("=>");
			int accountNum = scCommand.nextInt();
			System.out.print("-account " + accountNum +" balance: ");
			System.out.println(checkBalance(accountNum));
			System.out.println("Action: check balance done");
		}
		else if(inputCommand.equals("4")){
			System.out.println("Action: view history");
			System.out.println("-account number:");
			System.out.print("=>");
			int accountNum = scCommand.nextInt();
			viewHistory(accountNum);
			System.out.println("Action: show done");
		}
		else if(inputCommand.equals("5")){
			System.out.println("Action: calculate total");
			calcTotal();
			System.out.println("Action: calculate done");
		}
		else if(inputCommand.equals("6")){
			System.out.println("Action: show account list");
			showAccountList();
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
	
	public static void createAccount(){
		Account newAccount = new Account(accountNum_global);		
		accountsHash.put(accountNum_global,newAccount);
		accounts.add(accountNum_global);
		System.out.println("-new account: " + newAccount.accountNum);
		accountNum_global ++;
	}
	
	public static void deposit(int accountNum, Money money){
		Account currentAccount = (Account) accountsHash.get(accountNum);
		if(currentAccount == null){
			System.out.println("Error: No record for "+ accountNum);
		}
		else{
			currentAccount.newTransaction("deposit", money);
		}
		
	}
	
	public static void withdraw(int accountNum, Money money){
		Account currentAccount = (Account) accountsHash.get(accountNum);
		if(currentAccount == null){
			System.out.println("Error: No record for "+ accountNum);
		}
		else{
			currentAccount.newTransaction("withdraw", money);
		}
	}
	
	public static Money checkBalance(int accountNum){
		Account currentAccount = (Account) accountsHash.get(accountNum);
		if(currentAccount == null){
			System.out.println("Error: No record for "+ accountNum);
			return new Money();
		}
		else{
			return currentAccount.calcCurrentMoney();
		}
	}
	
	public static void viewHistory(int accountNum){
		Account currentAccount = (Account) accountsHash.get(accountNum);
		if(currentAccount == null){
			System.out.println("Error: No record for "+ accountNum);
		}
		else{
			System.out.println(currentAccount);
		}
	}
	
	public static void calcTotal(){
		Money totalMoney = new Money();
		for (Object account : accountsHash.values()){
			totalMoney = totalMoney.add(((Account)account).calcCurrentMoney());
		}
		System.out.println("-the total money for our bank is: "+ totalMoney);
	}
	
	public static void showAccountList(){
		String lines = "-All accounts in the system: ";
		//Money totalMoney = new Money();
		int sizeOfList = accounts.size();
		for(int index = 0; index < sizeOfList; index++){
			if(index%3 == 0){
				lines += "\n" + accounts.get(index);
			}
			else{
				lines += "\t" + accounts.get(index);
			}
		}
		System.out.print(lines+"\n");
	}
	
	
	
	
	

}
