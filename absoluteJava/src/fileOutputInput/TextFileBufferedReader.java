package fileOutputInput;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileBufferedReader{
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		

		
		try{
			BufferedReader inputStream =
				new BufferedReader(new FileReader("myIntegers.txt"));
			
		
			String line = inputStream.readLine();
			
			while(line != null){				
											
				System.out.println(line);
				line = inputStream.readLine();
				
			}			
			inputStream.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println("File cannot be found.");
		}
		catch(IOException e){
			System.out.println("Error reading.");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "ms");
	}
}