package IPP2;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 *
 * @author Benjamin Berman
 */
public class RecReader2 extends RecursiveReader {

    public RecReader2(String filename) throws FileNotFoundException, IOException {
        //FILL IN HERE--no for or while loops
    	super(filename);
    }
    /**
     * Reads a sequence of letters in the file and prints out the number of
     * consecutive character repetitions along with the character, in reverse 
     * order.  For instance if the file contains the single line
     * 
     * aaaaabbbcccccaa
     * 
     * then the method should print out the following 4 lines
     * 
     * 2 x a
     * 5 x c 
     * 3 x b 
     * 5 x a
     * 
     * If there are any non-letter characters, nothing should be printed and an
     * IOException should be thrown.
     * 
     * @throws IOException when a non-letter character (see 
     * java.lang.Character.isLetter(char)) is encountered
     * or any other IO problem occurs.
     */
   
    public void readFile() throws IOException {
        //FILL IN HERE--no for or while loops
    	int last_letter;
    	last_letter = readThrough();
    	
    	String tempChar = ""+ (char)last_letter;
		if(tempChar.matches("[a-zA-Z]+")){
			System.out.println(times+" x "+(char)last_letter);
		}
    }
    
    
    int times = 1;
    public int readThrough() throws IOException {
        //FILL IN HERE--no for or while loops
    	int letter,last_letter;
    	letter = consume();
    	last_letter = letter;
    	
    	if(letter != -1){
    		
    		String tempChar = ""+ (char)last_letter;
			
    		
	    		last_letter = readThrough();
	   		
	    		if(last_letter == letter){
	    			times = times + 1 ;	    			
	    		}
	    		else{
	    			if(last_letter != -1){
	    				tempChar = ""+ (char)last_letter;
	    				if(tempChar.matches("[a-zA-Z]+")){
	    					System.out.println(times+" x "+(char)last_letter);
	    				}    				
	    			}    			    			
	    		times = 1;
	    		}			
			}
    	
    	return letter;
    	

    }

}
