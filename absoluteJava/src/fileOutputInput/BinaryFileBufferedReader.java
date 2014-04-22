package fileOutputInput;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class BinaryFileBufferedReader{
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		PrintWriter outputStream = null;
		try{
			BufferedReader inputStream =
				new BufferedReader(new FileReader("myBinaryIntegers.dat"));
			outputStream = 
				new PrintWriter (new FileOutputStream("myBinaryIntegers.txt"));
			
			System.out.println("Loading binary integers...");
			
			String line = inputStream.readLine();
			
			while(line != null){						
				//System.out.println(line);
				outputStream.print(line);
				line = inputStream.readLine();
			}		
		
			outputStream.close();
			inputStream.close();			
			System.out.println("Done with read in binary integers!");
		}
		catch(FileNotFoundException e){
			System.out.println("File cannot be found when open for read.");
		}
		catch(IOException e){
			System.out.println("Error reading.");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "ms");
	}
}