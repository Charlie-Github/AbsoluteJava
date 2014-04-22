package fileOutputInput;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextFileInputScanner{
	public static void main(String args[]){
		
		
		long start = System.currentTimeMillis();
		

		
		Scanner inputStream = null;
		try{
			inputStream =
				new Scanner(new FileInputStream("myIntegers.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File test.txt was not found");
 			System.out.println("or could not be opened.");
 			System.exit(0);
		}
		
		System.out.println("Done with read integers");
		
		int counter = 0;
		while(inputStream.hasNextInt()){
			counter = inputStream.nextInt();
			System.out.println(counter);
		}
		
		inputStream.close();
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "ms");
	}
}