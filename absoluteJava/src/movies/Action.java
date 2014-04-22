package movies;

public class Action extends Movie {
	
	public double calcLateFees(int days){
		
		double  fee = 3 * days;		
		return fee;
		
	}
}
