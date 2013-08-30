package cs3213;


import java.util.ArrayList;
import java.util.Collections;

/*
 * Instance of this class sorts a collection of strings
 * and pass them to the next filter for execution
 */
public class Alphabetizer extends Filter{

	public Alphabetizer(Pipe inputP, Pipe outputP) {
		super(inputP, outputP);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void performIndependentTask() {
		
		if (this.inputPipe.isReadyToRead() && this.inputPackage == null){
			inputPackage = inputPipe.read();
			outputPackage = sortOutputList();
		}
		
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && this.inputPackage != null) {
			outputPipe.write(outputPackage);
			inputPackage = null;//clean inputList for next read
		}
	}
	
	
    private Package sortOutputList(){
    	ArrayList<String> temp = inputPackage.getStringsToProcess();
        Collections.sort(temp);
        
        return new Package(inputPackage.getWordsToIgnore(),temp);
	}
	

}
