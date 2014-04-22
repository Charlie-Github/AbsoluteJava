package fileOutputInput;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class TextFileOutput{
	public static void main(String args[]){
		
		
		long start = System.currentTimeMillis();
		
		PrintWriter outputStream = null;
		
		try{
			outputStream = 
					new PrintWriter (new FileOutputStream("myIntegers.txt"));
		}
		
		catch(FileNotFoundException e){
			System.out.println("Error opening the file.");
		}
		
		
		for(int i = 1; i <= 1000000; i++){
			outputStream.println(i);
		}
		
		outputStream.close();
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "millis");
	}
}