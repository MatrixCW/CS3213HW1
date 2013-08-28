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
		
		if (this.inputPipe.isReadyToRead() && this.inputList == null){
			
			System.out.println("Alphabetizer is now reading inputs");
			inputList = inputPipe.read();
			readyForProcessing = true;
		}
		
		if(readyForProcessing){
		
			addToOutputString();
		    sortOutputList();
		}
		//if current output list is not empty try to write it into outpipe
		if (outputPipe.isReadyToWrite() && this.inputList != null) {
			
			System.out.println("Alphabetizer is now producing outputs");
			outputPipe.write(outputList);
			inputList = null;//clean inputList for next read
			readyForProcessing = false;
			
		}
	}
	
	private void addToOutputString(){
		
		if(outputList == null){
			
			outputList = new ArrayList<String>();
			
		}
		
		
		for(String string : inputList){
			
			outputList.add(string);
			
		}
		
	}
	
    private void sortOutputList(){
    	
    	Collections.sort(outputList);
		
	}
	

}
