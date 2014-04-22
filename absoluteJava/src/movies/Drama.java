package movies;

public class Drama extends Movie {
	
	public double calcLateFees(int days){
		
		double  fee = 2 * days;		
		return fee;
		
	}
}
