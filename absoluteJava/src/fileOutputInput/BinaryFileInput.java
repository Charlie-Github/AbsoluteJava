package fileOutputInput;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryFileInput
{
	public static void main(String[] args)
	{
		
		long start = System.currentTimeMillis();
		

		try
		{
			ObjectInputStream inputFile =
					new ObjectInputStream( new
					FileInputStream("myBInaryIntegers.dat"));
			
			for (int i = 1; i <= 1000000; i++){
				int tempInt = inputFile.readInt();
				System.out.println(tempInt);
			}
				
				
			System.out.println("Numbers have been written to the file.");
			inputFile.close();
		}
		
		
		catch(IOException e)
		{
			//e.getStackTrace();
			System.out.println("Exception caught when input.");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "ms");
	}
}