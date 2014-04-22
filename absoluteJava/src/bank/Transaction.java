package bank;

import java.util.Date;

public class Transaction {
	String transactionType;
	int associateAccountNum;
	Date timeDate;
	Money tMoney;
	
	public Transaction(String tType, Money money){
		//constructor
		transactionType = tType;
		tMoney = money;
		timeDate = new Date();
		
	}
}
