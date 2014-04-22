package IPP2;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 *
 * @author Benjamin Berman
 */
public class RecReader1 extends RecursiveReader {

    public RecReader1(String filename) throws FileNotFoundException, IOException {
        //FILL IN HERE--no for or while loops
    	super(filename);
    }

    /**
     * Prints out each letter in the file on its own line.
     * @throws IOException 
     */
    @Override
    public void readFile() throws IOException {
        //FILL IN HERE--no for or while loops
    	int letter;
    	letter = consume();
    	if(letter != -1){
    		//System.out.print(letter);
    		char aletter = (char) letter;
    		System.out.println(aletter);
    		readFile();
    	}

    }
    
            
}
