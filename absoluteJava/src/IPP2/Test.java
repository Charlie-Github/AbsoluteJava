package IPP2;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Benjamin Berman
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("letters.txt"));
        pw.print("aaaabbbcccaaaacc");
        pw.close();
      
        
        RecursiveReader reader1 = new RecReader1("letters.txt");
        reader1.readFile();
        reader1.close();
        
       
        RecursiveReader reader2 = new RecReader2("letters.txt");
        reader2.readFile();
        reader2.close();
       
       
    }
}
