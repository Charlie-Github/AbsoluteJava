package movies;


public class Movie {
	protected String rate; 
	protected	String ID;
	protected String title;
	
	public Movie(){
		rate = "default_rate";
		ID = "default_ID";
		title = "default_title";
	}
	
	public void setRate(String inputrate){
		if(inputrate.equals("G")||inputrate.equals("g")){
			rate = "G";
		}
		else if(inputrate.equals("PG")||inputrate.equals("Pg")||inputrate.equals("pg")){
			rate = "PG";
		}
		else if(inputrate.equals("PG-13")||inputrate.equals("Pg-13")||inputrate.equals("pg-13")){
			rate = "PG-13";
		}
		else if(inputrate.equals("R")||inputrate.equals("r")){
			rate = "R";
		}
		else{
			System.out.println("Invalid input rate.");
		}
	}
	
	public void setID(String inputID){
		ID = inputID;
		System.out.println("New ID has been set: "+ inputID);
	}
	
	public void setTitle(String inputTitle){
		title = inputTitle;
		System.out.println("New Title has been set: "+ inputTitle);
	}
	
	
	public boolean equals(Movie inputMovie){
		if(this.ID.equals(inputMovie.ID)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public double calcLateFees(int days){
		
		double  fee = 2 * days;
		return fee;
		
	}
	
	public String toString(){
		String printMovie = "ID: "+ID +"\n"+"Title: "+title +"\n"+"Rate: "+rate;
		return printMovie;
	}

}
