package fileOutputInput;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileOutput
{
	public static void main(String[] args)
	{
		
		long start = System.currentTimeMillis();

		try
		{
			ObjectOutputStream outputStream =
				new ObjectOutputStream(
				new FileOutputStream("myBinaryIntegers.dat"));
			
			for (int i = 1; i<=1000000; i++){
				outputStream.writeInt(i);
			}
				
				
			System.out.println("Numbers have been written to the file.");
			outputStream.close();
		}
		catch(IOException e)
		{
			System.out.println("Problem with file output.");
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + ((end - start)) + "ms");
	}
}
		