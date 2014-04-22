package bank;

import java.util.ArrayList;
import java.util.Date;

public class Account {
	int accountNum;
	ArrayList<Transaction> transactions;
	
	
	public Account(int newNum){
		//constructor
		accountNum = newNum;		
		transactions = new ArrayList<Transaction>();
	}
		
	public Money calcCurrentMoney(){
		Money balance = new Money();
		int sizeOfList = transactions.size();
		for(int index = 0; index < sizeOfList; index++){
			if(transactions.get(index).transactionType == "deposit"){
				balance = balance.add(transactions.get(index).tMoney);
			}
			else if(transactions.get(index).transactionType == "withdraw"){
				balance = balance.minus(transactions.get(index).tMoney);
			}
		}
		return balance;
	}
		
	public void newTransaction(String transactionType, Money money){
		Transaction tSession = new Transaction(transactionType, money);
		transactions.add(tSession);
		
	}
		
	public String toString(){
		
		Money balance = calcCurrentMoney();
		
		String transactionType;
		Money money;
		String moneyString;
		Date tempTime;
		String lines = "=================Transactions History==========Account Number: "+ accountNum + "============\n";
				lines += "Index \t| Type \t\t| Amount \t| Time & Date \n";
		int sizeOfList = transactions.size();
		
		for(int index = 0; index < sizeOfList; index++){
			transactionType = transactions.get(index).transactionType;
			tempTime = transactions.get(index).timeDate;
			money = transactions.get(index).tMoney;
			lines += index + "\t|" + transactionType + "\t|" + money.toString() + "\t\t|" + tempTime.toString()+"\n";
		}
		lines += "Balance:" + balance + "=================\n";
		
		return lines;
	}
}
