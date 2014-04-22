package movies;

public class Comedy extends Movie {
	
	public double calcLateFees(int days){
		
		double  fee = 2.5 * days;		
		return fee;
		
	}
}
