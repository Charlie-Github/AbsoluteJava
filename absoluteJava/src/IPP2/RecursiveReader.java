package IPP2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Benjamin Berman
 */
public abstract class RecursiveReader {
    
    private BufferedReader br;
    
    private int lookAhead;
    private int lookAheadPosition;
    
    public RecursiveReader(String filename) throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(filename));
        lookAhead = br.read();
        lookAheadPosition = 0;
    }
    
    /**
     * Closes the underlying FileReader.
     * @throws IOException 
     */
    public void close() throws IOException {
        br.close();
    }
    
    /**
     * 
     * @returns the next character to be consumed as an int, 
     * or -1 for the end of the file. 
     */
    protected int lookAhead() {
        return lookAhead;
    }
    
    /**
     * 
     * @return the position of the next character to be consumed in the file 
     * (the first character is at position zero)
     */
    protected int lookAheadPosition() {
        return lookAheadPosition;
    }
    
    /**
     * Moves the lookAhead character forward one position in the file.
     * 
     * @returns the consumed character as an int, or -1 if at the end of 
     * the file.
     * @throws IOException 
     */
    protected int consume() throws IOException {
        int temp = lookAhead;
        
        if (lookAhead != -1)
            lookAheadPosition++;
        lookAhead = br.read();
        
        return temp;
    }
    
    /**
     * This method should be overridden to produce the desired effect from
     * reading the file.
     * 
     * @throws IOException 
     */
    public abstract void readFile() throws IOException;
    
   
}
