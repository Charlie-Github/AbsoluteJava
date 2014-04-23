package bank;

public class Money {
	//member vars
	int Dollars;
	int Cents;

	//first constructor, args: dollar & cents
	public Money(int inputDollars, int inputCents){
		Dollars = inputDollars;
		Cents = inputCents;
		//isNeg = false;
	}
	
	//second constructor, args: dollar
	public Money(int inputDollars){
		Dollars = inputDollars;
		Cents = 0; //this is a default value
		//isNeg = false;
	}
	
	//third constructor, non-args
	public Money(){
		Dollars = 0;//this is a default value
		Cents = 0;//this is a default value
		//isNeg = false;
	}
	
	//static function add(dollar,cents), return Money
	public static Money add(Money leftMoney, Money rightMoney){
		Money sumMoney = new Money();
		
		
		int leftDollars = leftMoney.Dollars;
		int leftCents = leftMoney.Cents;
		int rightDollars = rightMoney.Dollars;
		int rightCents = rightMoney.Cents;
		
		
		if(leftCents < 0 || rightCents < 0){
			System.out.println("You input a negtive amount of Cents!");
			System.exit(0);
		}
		
		
		Money tempLeft = new Money(leftDollars,leftCents);
		Money tempRight = new Money(rightDollars,rightCents);
		
		
		if(leftDollars < 0 && rightDollars  > 0){
			leftDollars = 0 - leftDollars;
			tempLeft.Dollars = leftDollars;
			//System.out.println(tempRight + "-" + tempLeft);
			//System.out.println(Money.minus(tempRight, tempLeft));
			sumMoney = Money.minus(tempRight, tempLeft);
		}
		
		else if(leftDollars > 0 && rightDollars  < 0){
			rightDollars = 0 - rightDollars;
			tempRight.Dollars = rightDollars;
			sumMoney = Money.minus(tempLeft, tempRight);			
		}
		
		else if(leftDollars < 0 && rightDollars  < 0){
			sumMoney.Dollars = 0 - (tempLeft.Dollars + tempRight.Dollars);
			sumMoney.Cents = tempLeft.Cents + tempRight.Cents;
			if(sumMoney.Cents >= 100){
				sumMoney.Dollars = sumMoney.Dollars - (int)sumMoney.Cents /100;
				sumMoney.Cents = sumMoney.Cents - ((int)sumMoney.Cents/100)*100;
			}
		}	
		else if(leftDollars >= 0 && rightDollars  >= 0){
			//Here we need to deal with the situation where amount = 0
			sumMoney.Dollars = tempLeft.Dollars + tempRight.Dollars;
			sumMoney.Cents = tempLeft.Cents + tempRight.Cents;
			if(sumMoney.Cents >= 100){
				sumMoney.Dollars = sumMoney.Dollars + (int)sumMoney.Cents /100;
				sumMoney.Cents = sumMoney.Cents - ((int)sumMoney.Cents/100)*100;
			}
		}
		
		return sumMoney;
	}
	
	//overload sum()
	public Money add(Money rightMoney){
		
		Money sumMoney = new Money();		
		

		sumMoney = Money.add(this,rightMoney);
		
		return sumMoney;
	}
	
	//static function minus(money, money), return Money
	public static Money minus(Money leftMoney, Money rightMoney){
		
		Money diffMoney = new Money();
		Money tempLeft = new Money();
		Money tempRight = new Money();
		
		boolean isNeg = false;
		
		if(leftMoney.Cents<0 || rightMoney.Cents<0){
			System.out.println("You cannot input a negtive Cents!");
			System.exit(0);
		}
		
		
		
		if(leftMoney.Dollars + leftMoney.Cents * 0.01 < rightMoney.Dollars + rightMoney.Cents*0.01){
			// swap two vars
			tempLeft = new Money (rightMoney.Dollars,rightMoney.Cents);
			tempRight = new Money (leftMoney.Dollars,leftMoney.Cents);
			isNeg = true;
			
		}
		else{
			
			tempLeft =  new Money (leftMoney.Dollars,leftMoney.Cents);
			tempRight = new Money (rightMoney.Dollars,rightMoney.Cents);		
			
		}		
		
		// operation
		if(tempLeft.Dollars > 0 && tempRight.Dollars < 0){
			tempRight.Dollars = 0-tempRight.Dollars;
			diffMoney.Dollars = Money.add(tempRight, tempLeft).Dollars;
			diffMoney.Cents = Money.add(tempRight, tempLeft).Cents;
		}
		else if(tempLeft.Dollars <= 0 && tempRight.Dollars <= 0){
			tempRight.Dollars = 0-tempRight.Dollars;
			tempLeft.Dollars = 0-tempLeft.Dollars;
			diffMoney.Dollars = Money.minus(tempLeft, tempRight).Dollars;
			diffMoney.Cents = Money.minus(tempLeft, tempRight).Cents;
			isNeg = true;			
		}
		else if(tempLeft.Dollars > 0 && tempRight.Dollars > 0){
			//base case			
			if(tempLeft.Cents < tempRight.Cents){		
				//borrow 1 
				tempLeft.Dollars = tempLeft.Dollars -1;
				tempLeft.Cents = tempLeft.Cents + 100;		
			}
			
			int tempDollars = (tempLeft.Dollars - tempRight.Dollars);
			int tempCents = (tempLeft.Cents - tempRight.Cents);
			
			diffMoney.Dollars = tempDollars;
			diffMoney.Cents = tempCents;			
			//System.out.println("base case " + diffMoney.toString());
		
		}
		
		if(isNeg){
			//System.out.println("isneg");
			if(diffMoney.Dollars > 0){				
				diffMoney.Dollars = 0 - diffMoney.Dollars;
			}
			else if(diffMoney.Dollars == 0){			
				diffMoney.Cents = 0 - diffMoney.Cents;
			}
		}
		
		return diffMoney;
	}
	
	//overload minus()
	//static function minus(money), return Money
		public Money minus(Money rightMoney){
			Money diffMoney = new Money();
			Money tempLeft = this;
			Money tempRight = rightMoney;
			
			diffMoney = Money.minus(tempLeft, tempRight);		
			
			return diffMoney;
		}
	
	//function equals(Money), return boolean
	public boolean equals(Money targetMoney){
		if(this.Dollars == targetMoney.Dollars && this.Cents == targetMoney.Cents){
			return true;
		}
		else{
			return false;
		}		
	}
	
	//function toString(), return String
	public String toString(){
		int dollars = this.Dollars;
		int cents = this.Cents;
		String printedMoney = new String();
		
		if(cents < 10 && cents >= 0){
			printedMoney = dollars + ".0" + cents;
		}
		else if(cents >= 10){
			printedMoney = dollars + "." + cents;
		}
		else if(cents < 0){
			printedMoney = "-" + dollars + "." + (0 - cents);
		}
		
		return "$"+printedMoney;
	}
}
