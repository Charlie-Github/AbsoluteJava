package eveHusbands;

import java.util.LinkedList;

public class EvePick {
	
	public static int numOfman;
	public static LinkedList<String> men = new LinkedList<String>();
	
	public static void main(String[] args) {	
		
		numOfman = 6;
		
		
		//initailize man list
		for(int index = 0; index < numOfman; index++){
			String indexToString = "" + (index+1);
			men.add(indexToString);
		}
		
	
		int counter = 1;
		int index = 0;
		
		//iterate man list
		while(men.size() > 1){
			//System.out.println(index);
			if(counter == 3){
				
				System.out.println("Remove: "+men.get(index));
				men.remove(index);
				counter = 1;				
				//index ++;
			}
			else{
				counter++;
				index++;
			}
			
			if(index == men.size()){
				//start from head
				index = 0;
			}			
		}
		
		String theMan = men.getFirst();
		System.out.println(theMan);

	}
	
	
	

}
