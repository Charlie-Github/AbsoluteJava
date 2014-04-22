package movies;

public class testMovies {

	public static void main(String[] args) {
		
		Movie action = new Action();
		action.setID("01");
		action.setRate("R");
		action.setTitle("Need for Speed");
		
		System.out.println(action);
		
		double fee1 = action.calcLateFees(3);
		System.out.println(fee1);
		
		
	}

}
